FROM java:8
FROM maven:alpine

WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD target/amazingco-api-0.0.1-SNAPSHOT.jar amazingco-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","amazingco-api-0.0.1-SNAPSHOT.jar"]