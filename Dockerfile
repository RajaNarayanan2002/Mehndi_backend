# Use official OpenJDK 21 image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Grant permission to Maven wrapper
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the built JAR (update JAR name if needed)
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
