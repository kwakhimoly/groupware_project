FROM adoptopenjdk:11-jdk-hotspot AS builder
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +X ./gradlew
RUN chmod 755 ./gradlew
RUN ./gradlew bootJar

FROM adoptopenjdk:11-jdk-hotspot
COPY --from=builder build/libs/*.jar app.jar

#EXPOSE 6047
ENTRYPOINT ["java", "-jar", "/app.jar"]
