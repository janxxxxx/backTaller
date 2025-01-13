
# Etapa 1: Construcción
FROM maven:3.6.3-openjdk-17 AS build
WORKDIR /home/app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Runtime
FROM openjdk:19-jdk
WORKDIR /home/app
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 82
ENV SPRING_PROFILES_ACTIVE=docker
ENTRYPOINT ["java", "-jar", "/home/app/app.jar"]
