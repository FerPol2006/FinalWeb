# ==========================================
# Etapa 1: Construcción (Build)
# ==========================================
# Cambiamos a la imagen que corresponde con la versión requerida por Spring Boot 4.1.0
FROM gradle:8.14-jdk17 AS build
WORKDIR /app
COPY . .
# Construye el proyecto omitiendo las pruebas
RUN gradle clean build -x test

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia el JAR generado en la etapa anterior
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]