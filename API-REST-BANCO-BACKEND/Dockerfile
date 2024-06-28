FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/API-REST-BANCO-BACKEND-0.0.1.jar
COPY  ${JAR_FILE} app_bancoa.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_bancoa.jar"]