FROM eclipse-temurin:17
VOLUME /tmp
COPY target/employee-directory.jar employee_directory.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/employee_directory.jar"]