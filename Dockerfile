# Stage 1
FROM maven3.8.1-openjdk-8-slim as build-step
RUN mkdir /service
WORKDIR /service
COPY . /service
RUN mvn clean install

# Stage 1
FROM openjdk:8-alpine3.9
EXPOSE 8080
COPY --from=build-step /service/target/*.jar service.jar
ENTRYPOINT ["java","-jar","/service.jar"]
