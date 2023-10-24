FROM openjdk:11
EXPOSE 8000
ARG JAR_FILE=target/*.jar
COPY ./target/currency-exchange-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
