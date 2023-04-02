FROM openjdk:17-oracle
WORKDIR /
COPY target/javaxrayclient-0.0.1-SNAPSHOT.jar javaxrayclient-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD java -jar javaxrayclient-0.0.1-SNAPSHOT.jar