# Estágio 1: Build
FROM eclipse-temurin:21-jdk-jammy AS builder
WORKDIR /build
COPY . .
RUN apt-get update && apt-get install -y maven && \
    mvn -f product/pom.xml clean package -DskipTests

# Estágio 2: Runtime
FROM eclipse-temurin:21-jre-jammy
ARG JAR_FILE=product/target/*.jar
COPY --from=builder /build/${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx512m", "-Xms256m", "-jar", "/app.jar"]
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1