FROM eclipse-temurin:17
WORKDIR app
COPY target/*.jar employees.jar
ENTRYPOINT ["java", "-jar", "employees.jar"]