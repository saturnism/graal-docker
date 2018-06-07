FROM maven:3.5-jdk-8-slim AS build
COPY . /src
RUN cd /src && mvn package

FROM saturnism/graal:1.0.0-rc2 AS graal
COPY --from=build /src/target/helloworld-1.0-SNAPSHOT.jar /app/helloworld.jar
RUN cd /app && native-image --static -jar helloworld.jar

FROM scratch
COPY --from=graal /app/helloworld /app
ENTRYPOINT ["/app"]
