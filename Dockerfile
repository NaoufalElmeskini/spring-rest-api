# Stage 1 — Build
# Uses a full Maven + JDK image to compile the project and produce a fat JAR.
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy the dependency manifest first so Docker can cache the dependency layer.
# Dependencies are only re-downloaded when pom.xml changes.
COPY pom.xml .
RUN mvn dependency:go-offline -q

# Copy source and build, skipping tests (tests should run in CI, not at image build time).
COPY src ./src
RUN mvn clean package -DskipTests -q

# Stage 2 — Run
# Uses a minimal JRE-only image to keep the final image small.
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/target/spring-rest-api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
