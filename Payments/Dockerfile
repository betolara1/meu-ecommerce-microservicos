# Estágio 1: Build
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build
COPY . .
RUN mvn -f payments/pom.xml clean package -DskipTests

# Estágio 2: Runtime
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=payments/target/*.jar
COPY --from=builder /build/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-jar", "/app.jar"]
HEALTHCHECK --interval=30s --timeout=5s --start-period=15s --retries=3 \
    CMD curl -f http://localhost:8080/ || exit 1