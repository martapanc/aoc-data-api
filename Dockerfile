FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts gradlew ./
COPY gradle ./gradle

RUN ./gradlew dependencies

COPY src ./src

RUN ./gradlew build

ENTRYPOINT ["java", "-jar", "build/libs/aoc-data-api-1.0.0.jar"]
