FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} billing-1.1-RELEASE.jar
ENTRYPOINT ["java","-jar","/billing-1.1-RELEASE.jar"]
EXPOSE 9002