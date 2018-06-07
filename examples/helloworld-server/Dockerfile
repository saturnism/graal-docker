FROM maven:3.5-jdk-8-slim AS build
COPY . /src
WORKDIR /src
RUN mvn package

FROM saturnism/graal:1.0.0-rc2 AS graal
COPY --from=build /src/target/helloworld-server-1.0-SNAPSHOT.jar /app/helloworld-server.jar
COPY graal/*.json /app
WORKDIR /app
RUN native-image \ 
    --verbose \
    --no-server \
    -H:ReflectionConfigurationFiles=reflect.json \
    -H:+ReportUnsupportedElementsAtRuntime \
    --static \
    -jar helloworld-server.jar


FROM scratch
COPY --from=graal /app/helloworld-server /app
ENTRYPOINT ["/app"]
