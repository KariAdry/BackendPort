FROM amazoncorreto:11-alpine-jdk
MAINTAINER karina
COPY target/backendPort-0.0.1-SNAPSHOT  kary-app.jar
ENTRYPOINT ["java", "-jar", "/kary-app.jar"]
 
