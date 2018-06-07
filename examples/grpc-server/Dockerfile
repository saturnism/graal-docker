FROM maven:3.5-jdk-8-slim AS build
COPY . /src
WORKDIR /src
RUN mvn package

FROM saturnism/graal:1.0.0-rc2 AS graal
COPY --from=build /src/target/grpc-server-1.0-SNAPSHOT.jar /app/grpc-server.jar
COPY graal/*.json /app
WORKDIR /app
RUN native-image \ 
    --verbose \
    --no-server \
    -H:ReflectionConfigurationFiles=reflect.json \
    -H:+ReportUnsupportedElementsAtRuntime \
    --static \
    -jar grpc-server.jar


#FROM gcr.io/distroless/cc
FROM scratch
COPY --from=graal /app/grpc-server /app
ENTRYPOINT ["/app"]
