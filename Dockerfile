FROM eclipse-temurin:11
VOLUME /tmp

ARG JAR_FILE=target/AerisDemoProgram.jar
COPY ${JAR_FILE} AerisDemoProgram.jar

COPY ./src/data/concentration.timeseries.nc /

ENTRYPOINT ["java","-jar","/AerisDemoProgram.jar"]
