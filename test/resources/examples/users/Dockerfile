FROM openjdk:19

ADD blockware.yml /application/blockware.yml
ADD target/todo.jar /application/todo.jar

WORKDIR /application

CMD [ "java", "-jar", "/application/todo.jar" ]
