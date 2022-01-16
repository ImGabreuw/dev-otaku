FROM maven:3.6-alpine AS dependencies

WORKDIR /app

RUN POM_FILES=$(find . -value pom.xml); export POM_FILES
COPY $POM_FILES ./
RUN mvn -B -e -C org.apache.maven.plugins:maven-dependency-plugin:3.2.0:go-offline

FROM maven:3.8.3-openjdk-17-slim AS builder

WORKDIR /app

COPY --from=dependencies /root/.m2 /root/.m2
COPY --from=dependencies /app/ ./
COPY . .
RUN mvn -B -e clean install

FROM openjdk:jre-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
ENTRYPOINT java -jar app.jar
EXPOSE 8080