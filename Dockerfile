FROM amazoncorretto:11-alpine-jdk
MAINTAINER karina
COPY target/backendPort-0.01-SNAPSHOT.jar karina-app.jar
ENTRYPOINT ["java","jar","/karina-app.jar"]
