FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} techinterview.jar
ENTRYPOINT ["java","-jar","/techinterview.jar"]