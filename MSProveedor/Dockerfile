# Maven para construir el proyecto
# Etapa de compilación
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /home/app
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 83
COPY --from=build /home/app/target/*.jar app.jar
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]
