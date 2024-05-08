/**
 * Copyright 2023 Kapeta Inc.
 * SPDX-License-Identifier: MIT
 */
import cheerio from 'cheerio';
import { GeneratedFile, SourceFile } from '@kapeta/codegen-target';

function decodeEntities(encodedString: string) {
    const translate_re = /&(nbsp|amp|quot|lt|gt);/g;
    const translate: any = {
        nbsp: ' ',
        amp: '&',
        quot: '"',
        lt: '<',
        gt: '>',
    };
    return encodedString
        .replace(translate_re, function (match, entity) {
            return translate[entity];
        })
        .replace(/&#(\d+);/gi, function (match, numStr) {
            const num = parseInt(numStr, 10);
            return String.fromCharCode(num);
        })
        .replace(/&#x(\d+);/gi, function (match, numStr) {
            const num = parseInt(numStr, 16);
            return String.fromCharCode(num);
        });
}

const dependencyFinder = (doc: cheerio.Root, groupId: string, artifactId: string) => {
    return (child: cheerio.Element) => {
        if (groupId !== doc('groupId', child).text()) {
            return false;
        }

        return artifactId === doc('artifactId', child).text();
    };
};

export const mergePom = (
    sourceFile: SourceFile,
    newFile: GeneratedFile,
    lastFile: GeneratedFile | null
): GeneratedFile => {
    // We can merge the dependencies into existing pom.xml without overwriting
    // the existing user adjusted content

    const targetDoc = cheerio.load(sourceFile.content, {
        xmlMode: true,
    });

    const newDoc = cheerio.load(newFile.content, {
        xmlMode: true,
    });

    const lastDoc = lastFile
        ? cheerio.load(lastFile.content, {
              xmlMode: true,
          })
        : null;

    const targetDependencies = targetDoc('dependencies > dependency');
    const newDependencies = newDoc('dependencies > dependency');
    const lastDependencies = lastDoc ? lastDoc('dependencies > dependency') : null;

    const targetDependenciesList = targetDependencies.toArray();
    const newDependenciesList = newDependencies.toArray();
    const lastDependenciesList = lastDependencies ? lastDependencies.toArray() : null;
    if (newDependenciesList && targetDependenciesList) {
        newDependenciesList.forEach((newDependency) => {
            const newGroupId = newDoc('groupId', newDependency).text();
            const newArtifactId = newDoc('artifactId', newDependency).text();
            const newVersion = newDoc('version', newDependency).text();

            const existing = targetDependenciesList.find(dependencyFinder(targetDoc, newGroupId, newArtifactId));

            const last =
                lastDoc && lastDependenciesList
                    ? lastDependenciesList.find(dependencyFinder(lastDoc, newGroupId, newArtifactId))
                    : undefined;

            if (existing) {
                const targetVersion = targetDoc('version', existing);
                const existingVersion = targetVersion.text();

                if (lastDoc && last) {
                    const lastVersionElm = lastDoc('version', last);
                    const lastVersion = lastVersionElm.text();
                    if (existingVersion !== lastVersion) {
                        // The user has changed the version, so we should not overwrite it
                        return;
                    }
                }

                if (existingVersion !== newVersion) {
                    targetVersion.text(newVersion);
                }
            } else {
                if (last) {
                    // The user has removed the dependency, so we should not re-add it
                    return;
                }

                // @ts-ignore
                const $newDependency = newDoc(newDependency).clone();
                targetDependencies.last().after(`\n        <dependency>${$newDependency.html()}</dependency>`);
            }
        });
    }

    if (lastDoc && lastDependenciesList) {
        lastDependenciesList.forEach((lastDependency) => {
            const lastGroupId = lastDoc('groupId', lastDependency).text();
            const lastArtifactId = lastDoc('artifactId', lastDependency).text();

            const newDependency = newDependenciesList.find(dependencyFinder(newDoc, lastGroupId, lastArtifactId));
            const existing = targetDependenciesList.find(dependencyFinder(targetDoc, lastGroupId, lastArtifactId));

            if (newDependency) {
                // New version also has this dependency, so we should not remove it
                return;
            }

            if (!existing) {
                // It's not there right now so nothing to remove
                return;
            }

            const targetVersion = targetDoc('version', existing);
            const existingVersion = targetVersion.text();

            const lastVersion = lastDoc('version', lastDependency);
            if (lastVersion.text() !== existingVersion) {
                // The user has changed the version, so we should not remove it
                return;
            }

            targetDoc(existing).remove();
        });
    }

    return {
        ...newFile,
        content: decodeEntities(targetDoc.xml()),
    };
};
