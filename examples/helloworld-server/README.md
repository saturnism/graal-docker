This is an example of building a small service using SparkJava, and compile into a static binary.

## Build & Run

Pure Java:
```
$ mvn package
$ java -jar target/helloworld-server-1.0-SNAPSHOT.jar
$ curl localhost:5432/hello/Ray
```

Graal (with Docker):
```
$ docker build -t helloworld-server
$ docker run -ti --rm helloworld-server -p 5432:5432 helloworld-server
$ curl localhost:5432/hello/Ray
```

## Graal Native Image
This example uses Graal to compile the fat JAR into a single statically linked binary.
The JAR itself is ~2.7MB, but of course, it'll require a JVM to run. But the statically linked binary is only ~15MB!

```
$ docker history helloworld-server <- This is only ~15MB large!
```

In the [Dockerfile](Dockerfile), I used multi-stage build:
1. Use Maven to build the fat JAR
1. Use Graal to build the statically linked binary
1. Copy the binary into `scratch` container base image.

This produces a 15MB image!

## Dealing with Reflection
This example uses Gson to serialize POJO into JSON. When doing this, Gson uses reflection on the POJO to construct the JSON payload. When using Graal, all reflections must be explicitly configured in a [Relfection Configuration](https://github.com/oracle/graal/blob/master/substratevm/REFLECTION.md). In this example, [relfection.json](graal/reflection.json) enables reflection on all fields and methods on the POJO `GreetingResponse`.

## Ctrl+C?
When running the JAR in JVM, I can Ctrl+C to stop the server. However, when running the statically linked binary, Ctrl+C seems broken. To stop the server, I needed to kill it explicitly:

```
$ docker ps   <-- find the container ID
$ docker kill [the container ID]
```
