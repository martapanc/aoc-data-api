#!/bin/bash

./gradlew clean build

docker build --build-arg JAR_FILE=build/libs/\*.jar -t aoc-data-api-docker .

docker run -p 8087:8080 --name aoc-data-api aoc-data-api-docker
