# --- Frontend build stage ---
FROM node:18 AS frontend-builder

# Werk in de frontend-vue directory
WORKDIR /app/frontend

# Kopieer de Vue.js bestanden
COPY frontend-vue/package*.json ./

# Installeer dependencies
RUN npm install

# Kopieer de rest van de frontend code
COPY frontend-vue/ .

# Build de productie bestanden
RUN npm run build

# --- Backend build stage ---
FROM maven:3.9.4-eclipse-temurin-17 AS backend-builder

# Werk in de backend-java directory
WORKDIR /app/backend

# Kopieer Maven configuratie
COPY backend-java/pom.xml .

# Pre-cache dependencies
RUN mvn dependency:resolve

# Kopieer de rest van de backend code
COPY backend-java/ .

# Build de backend applicatie
RUN mvn package -DskipTests

# --- Final stage ---
FROM eclipse-temurin:17-jre

# Set de werkdirectory
WORKDIR /app

# Kopieer backend JAR bestand
COPY --from=backend-builder /app/backend/target/*.jar app.jar

# Kopieer frontend bestanden
COPY --from=frontend-builder /app/frontend/dist /app/frontend

# Expose de backend port
EXPOSE 8080

# Start de Java backend app
CMD ["java", "-jar", "app.jar"]
