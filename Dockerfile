FROM openjdk:8-jdk-alpine
EXPOSE 8080
RUN mkdir -p /app/
ADD target/simple-rest-api-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=default", "-jar", "/app/app.jar"]