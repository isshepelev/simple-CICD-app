FROM maven:latest AS build
WORKDIR /app
COPY . .
RUN mvn clean verify

FROM openjdk:17-oracle
COPY --from=build /app/target/simple-CICD-app-*.jar app.jar
EXPOSE 8080
CMD ["sh", "-c", "exec java -Djava.security.egd=file:/dev/./urandom -jar app.jar"]