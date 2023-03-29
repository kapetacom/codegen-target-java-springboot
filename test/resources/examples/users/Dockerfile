FROM openjdk:19

ADD kapeta.yml /application/kapeta.yml
ADD target/todo.jar /application/todo.jar

WORKDIR /application

CMD [ "java", "-jar", "/application/todo.jar" ]
