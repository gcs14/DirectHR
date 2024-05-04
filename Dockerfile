FROM eclipse-temurin:17
COPY target/DirectHR.jar /DirectHR.jar
ENTRYPOINT ["java", "-jar", "/DirectHR.jar"]