# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container at /app
COPY target/item-cart-0.0.1.jar /app/item-cart-0.0.1.jar

# Expose the port your application will run on
EXPOSE 8080

# Define the command to run your application when the container starts
CMD ["java", "-jar", "item-cart-0.0.1.jar"]
