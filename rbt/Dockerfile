FROM java:8-jre

ADD ./target/passage-gc.jar /app/
CMD ["java", "-Xmx1024m", "-jar", "/app/passage-gc.jar"]

EXPOSE 8080