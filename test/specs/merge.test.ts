import {describe, test, beforeEach, expect} from "@jest/globals";
import Target from "../../src";
import Path from "path";
import FS from "fs";

function readString(path: string) {
    return FS.readFileSync(
        Path.resolve(__dirname, path),
        "utf-8"
    ).toString();
}


describe("merging", () => {
    let target: Target;

    beforeEach(() => {
        target = new Target({});
    });

    function doMergeContent(filename: string, original: string, changed: string) {
        const merged = target.mergeFile(
            {
                filename: filename,
                permissions: "644",
                content: original,
            },
            {
                filename: filename,
                permissions: "644",
                content: changed,
                mode: "merge",
            }
        );

        return merged.content;
    }

    describe("Can merge files: pom.xml", () => {
        const FILENAME = "pom.xml";

        test("new dependencies will be added", () => {
            const original = readString("../resources/packages/original.pom.xml");
            const changed = readString("../resources/packages/added-dependencies.pom.xml");
            const result = doMergeContent(FILENAME, original, changed);
            expect(result).toEqual(changed);
        });

        test("removed dependencies will be ignored", () => {
            const original = readString("../resources/packages/original.pom.xml");
            const changed = readString(
                "../resources/packages/removed-dependencies.pom.xml"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(result).toEqual(original);
        });

        test("existing dependencies will be upgraded", () => {
            const original = readString("../resources/packages/original.pom.xml");
            const changed = readString(
                "../resources/packages/upgraded-dependencies.pom.xml"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(result).toEqual(changed);
        });

    });

    describe("Can merge files: devcontainer.json", () => {
        const FILENAME = ".devcontainer/devcontainer.json";

        test("adding kapeta env is persisted", () => {
            const original = readString("../resources/devcontainer/original.json");
            const changed = readString(
                "../resources/devcontainer/added-kapeta-env.json"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(JSON.parse(result)).toEqual(JSON.parse(changed));
        });

        test("changed kapeta env is persisted", () => {
            const original = readString("../resources/devcontainer/original.json");
            const changed = readString(
                "../resources/devcontainer/changed-kapeta-env.json"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(JSON.parse(result)).toEqual(JSON.parse(changed));
        });

        test("removed kapeta env is persisted", () => {
            const original = readString("../resources/devcontainer/original.json");
            const changed = readString(
                "../resources/devcontainer/removed-kapeta-env.json"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(JSON.parse(result)).toEqual(JSON.parse(changed));
        });

        test("changed top level is ignored", () => {
            const original = readString("../resources/devcontainer/original.json");
            const changed = readString(
                "../resources/devcontainer/changed-top-level.json"
            );
            const result = doMergeContent(FILENAME, original, changed);
            expect(JSON.parse(result)).toEqual(JSON.parse(original));
        });

        test("original changes are retained", () => {
            const original = readString(
                "../resources/devcontainer/original-adjusted.json"
            );
            let changed = readString(
                "../resources/devcontainer/added-kapeta-env.json"
            );
            const changedData = JSON.parse(changed);
            changedData.containerEnv["SOME_OTHER_ENV_VAR"] = "some-value";
            changed = JSON.stringify(changedData, null, 4);
            const result = doMergeContent(FILENAME, original, changed);
            expect(JSON.parse(result)).toEqual(JSON.parse(changed));
        });
    });
});
