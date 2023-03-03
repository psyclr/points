FROM gradle:8.0.1-jdk17 as builder
WORKDIR /home/gradle/src
COPY --chown=gradle:gradle . .
RUN set -x \
    && gradle build

FROM amazoncorretto:17-alpine
WORKDIR /srv
COPY --from=builder /home/gradle/src/build/libs/points*-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
