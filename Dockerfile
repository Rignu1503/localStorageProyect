# Etapa de construcción (builder)
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app

# Copiar archivos de configuración y dependencias primero para aprovechar la caché
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiar el código fuente
COPY src ./src

# Compilar el proyecto sin ejecutar pruebas
RUN mvn clean package -DskipTests

# Etapa de producción (imagen final más ligera)
FROM eclipse-temurin:17-jdk-alpine as prod
WORKDIR /app

# Copiar el jar desde la etapa de build
COPY --from=builder /app/target/localStorageProyect-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usa tu app Spring Boot
EXPOSE 8080

# Comando de inicio
ENTRYPOINT ["java", "-jar", "app.jar"]
