# ==========================================
# Etapa 1: Construcción (Build)
# ==========================================
# Usamos una imagen de Gradle con JDK 17
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
# Construye el proyecto omitiendo las pruebas
RUN gradle clean build -x test

# ==========================================
# Etapa 2: Ejecución (Run)
# ==========================================
# Usamos la imagen oficial de Eclipse Temurin basada en Alpine (muy ligera) con solo el JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia el JAR generado en la etapa anterior
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]