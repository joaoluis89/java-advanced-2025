FROM ubuntu:latest as base

COPY . .

RUN apt-get update
RUN apt-get install openjdk-21-jdk -y
RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21-slim

EXPOSE 8080

COPY --from=base target/java-advanced-0.0.1-SNAPSHOT.jar demo.jar

ENTRYPOINT ["java", "-jar", "demo.jar"]
