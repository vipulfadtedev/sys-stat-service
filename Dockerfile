FROM openjdk:8-alpine3.9

EXPOSE 8080

ADD target/*.jar service.jar

ENTRYPOINT ["java","-jar","/service.jar"]
