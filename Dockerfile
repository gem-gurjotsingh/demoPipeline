FROM openjdk:17

COPY target/demoPipeline-0.0.1-SNAPSHOT.jar demoPipeline-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/demoPipeline-0.0.1-SNAPSHOT.jar"]