# ---------- Build Stage ----------
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# ---------- Runtime Stage ----------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Expose the port Render provides
EXPOSE 8080

# Run the app on the port Render assigns
ENTRYPOINT ["java","-jar","app.jar","--server.port=${PORT}"]
 
