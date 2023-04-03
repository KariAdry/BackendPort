FROM amazoncorretto:11-alpine-jdk
MAINTAINER karina
COPY target/backendPort-0.0.1-SNAPSHOT.jar  kary-app.jar
ENTRYPOINT ["java","-jar","/kary-app.jar"]
EXPOSE 8080

