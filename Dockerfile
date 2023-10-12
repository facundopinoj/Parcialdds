# Etapa de construcción
FROM alpine:latest as build

RUN apk update
RUN apk add openjdk17

COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar --no-daemon

# Etapa de ejecución
FROM alpine:latest
EXPOSE 8080
#Cambie 9000 a 8080
# Instalar OpenJDK 17
RUN apk update && apk add openjdk17

# Copiar el JAR construido desde la etapa de construcción
COPY --from=build ./build/libs/parcialdds-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t parcialback-il:latest .
#docker run -p 9000:8080 parcialback-il:latest

#http://localhost:9000/

