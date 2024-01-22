#
# Build stage
#
FROM maven:3.8.2-openjdk-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src src
RUN mvn clean package -DskipTests

# Package stage
FROM openjdk:11-jdk-slim
WORKDIR /app
COPY --from=build /app/target/tickets-0.0.5-SNAPSHOT.jar demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]