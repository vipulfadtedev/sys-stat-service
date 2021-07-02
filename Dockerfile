FROM adoptopenjdk:11-jre-hotspot

EXPOSE 8080

COPY target/*.jar service.jar

ENTRYPOINT ["java","-jar","/service.jar"]
