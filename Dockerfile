FROM openjdk:17-alpine
RUN ./mvnw clean package -DskipTests
ADD /target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]