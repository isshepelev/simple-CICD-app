FROM maven as build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY /src ./src
RUN mvn clean verify

FROM openjdk:17-oracle
ENV JAVA_OPTS="-Xmx256m"
COPY --from=build /app/target/cicd-*.jar app.jar
EXPOSE 8080
CMD ["sh", "-c", "exec java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar app.jar"]


