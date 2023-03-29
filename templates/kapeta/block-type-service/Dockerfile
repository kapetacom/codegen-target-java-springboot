##FILENAME:Dockerfile:merge
FROM openjdk:19

ADD kapeta.yml /application/kapeta.yml
ADD target/{{options.artifactId}}.jar /application/{{options.artifactId}}.jar

WORKDIR /application

CMD [ "java", "-jar", "/application/{{options.artifactId}}.jar" ]
