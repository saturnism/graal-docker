This is an example of building a small service using SparkJava, and compile into a static binary.

## Build & Run

Pure Java:
```
$ mvn package
$ java -jar target/helloworld-server-dagger-1.0-SNAPSHOT.jar
$ curl localhost:5432/hello/Ray
```

Graal (with Docker):
```
$ docker build -t helloworld-server-dagger
$ docker run -ti --rm -p 5432:5432 helloworld-server-dagger
$ curl localhost:5432/hello/Ray
```

## Graal Native Image
This example uses Graal to compile the fat JAR into a single statically linked binary.
The JAR itself is ~2.8MB, but of course, it'll require a JVM to run. But the statically linked binary is only ~15MB!

In the [Dockerfile](Dockerfile), I used multi-stage build:
1. Use Maven to build the fat JAR
1. Use Graal to build the statically linked binary
1. Copy the binary into `scratch` container base image.

This produces a 15MB image!

```
$ docker history helloworld-server-dagger
IMAGE           CREATED    CREATED BY                                      SIZE                COMMENT
f8907debcf74    ...        /bin/sh -c #(nop)  ENTRYPOINT ["/app"]          0B                  
424f21af7a29    ...        /bin/sh -c #(nop) COPY file:48e600b865ad2652…   15.2MB
```

## Dealing with Reflection
This example uses Gson to serialize POJO into JSON. When doing this, Gson uses reflection on the POJO to construct the JSON payload. When using Graal, all reflections must be explicitly configured in a [Relfection Configuration](https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md). In this example, [relfect.json](graal/reflect.json) enables reflection on all fields and methods on the POJO `GreetingResponse`.

## Ctrl+C?
When running the JAR in JVM, I can Ctrl+C to stop the server. However, when running the statically linked binary, Ctrl+C seems broken. To stop the server, I needed to kill it explicitly:

```
$ docker ps   <-- find the container ID
$ docker kill [the container ID]
```
