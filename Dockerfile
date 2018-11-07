FROM mysql:5.7

FROM java:8
FROM maven:alpine



WORKDIR /app

COPY . /app

RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD target/amazingco-api-0.0.1-SNAPSHOT.jar amazingco-api-0.0.1-SNAPSHOT.jar
ADD waitForMySQL.sh /root/
RUN chmod +x /root/waitForMySQL.sh
ENTRYPOINT ["/bin/bash", "/root/waitForMySQL.sh"]