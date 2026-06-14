# ==========================================
# Etapa 1: Construcción (Build)
# ==========================================
# Usamos una imagen de Gradle con JDK 17 para construir el proyecto
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
# Construye el proyecto omitiendo las pruebas para que sea más rápido
RUN gradle clean build -x test

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
# Usamos una imagen de Eclipse Temurin, que es el OpenJDK soportado por la comunidad
FROM eclipse-temurin:17-jdk-slim
WORKDIR /app
# Copia el JAR generado en la etapa anterior
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]