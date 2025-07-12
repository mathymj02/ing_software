# Usar imagen base con Maven pre-instalado
FROM maven:3.8.6-openjdk-17-slim

# Instalar curl para troubleshooting (opcional)
RUN apt-get update && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

# Establecer directorio de trabajo
WORKDIR /app

# Copiar archivos de configuración de Maven
COPY pom.xml .

# Copiar código fuente
COPY src ./src

# Construir la aplicación
RUN mvn clean package -DskipTests

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/hotel-veranum-0.0.1-SNAPSHOT.jar"]
