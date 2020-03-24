//#FILENAME:Dockerfile:write-always
/**
 * GENERATED SOURCE - DO NOT EDIT
 */
FROM openjdk:8

ADD target/{{jarName}}.jar block.jar
CMD [ "java", "-jar", "/block.jar" ]

EXPOSE {{port}}
