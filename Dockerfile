FROM openjdk:20
ADD build/libs/springboot-mongodb-docker-0.0.1-SNAPSHOT.jar springboot-mongodb-docker-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "springboot-mongodb-docker-0.0.1-SNAPSHOT.jar"]