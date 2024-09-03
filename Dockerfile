FROM openjdk:17-alpine
COPY . .
RUN ./mvnw clean package -DskipTests
ADD /target/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]