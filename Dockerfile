FROM openjdk:24-ea-21-slim-bullseye
WORKDIR /app
COPY target/CrudSecurity-0.0.1-SNAPSHOT.jar /app/security.jar
ENTRYPOINT ["java", "-jar", "security.jar"]