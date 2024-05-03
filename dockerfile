FROM openjdk:17-oracle
VOLUME /tmp
ADD target/assignment-0.0.1-SNAPSHOT.jar assignsrvr.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/assignsrvr.jar"]
