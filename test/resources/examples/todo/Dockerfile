FROM openjdk:8

ADD block.yml /application/block.yml
ADD target/todo.jar /application/todo.jar

WORKDIR /application

CMD [ "java", "-jar", "/application/todo.jar" ]
