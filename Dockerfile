# ==========================================
# Etapa 1: Construcción (Build)
# ==========================================
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
# Construye el proyecto omitiendo las pruebas para que sea más rápido
RUN gradle clean build -x test

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copia el JAR generado en la etapa anterior
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]