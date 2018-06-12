#FROM alpine:latest
FROM anapsix/alpine-java
EXPOSE 8080
COPY target/*.jar /eddieui-server.jar
RUN apk update
RUN apk add openjdk8
#CMD ["java", "-jar", "srflow.jar"]
ENTRYPOINT exec java $JAVA_OPTS -jar /eddieui-server.jar