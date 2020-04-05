##FILENAME:Dockerfile:merge
FROM openjdk:8

ADD block.yml /application/block.yml
ADD target/{{options.artifactId}}.jar /application/{{options.artifactId}}.jar

WORKDIR /application

CMD [ "java", "-jar", "/application/{{options.artifactId}}.jar" ]
