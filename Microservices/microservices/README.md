# Microservices with API Gateway (Spring Cloud)

This project contains three Spring Boot Maven projects, matching the hands-on
exercise "Create a Spring Cloud API Gateway and call one microservice thru the
API gateway, with a global filter that logs each request":

1. **eureka-server** — Eureka Discovery Server (port 8761)
2. **greet-service** — Simple microservice returning "Hello World!!" at `/greet` (port 8080), registers itself with Eureka
3. **api-gateway** — Spring Cloud Gateway that routes to registered services and logs every request (port 9090)

## Requirements

- JDK 17
- Maven 3.6+
- Internet access (to download dependencies from Maven Central) the first time you build

## Build

From each project folder, run:

```bash
cd eureka-server
mvn clean package

cd ../greet-service
mvn clean package

cd ../api-gateway
mvn clean package
```

Or build all three from the parent `microservices` folder:

```bash
for d in eureka-server greet-service api-gateway; do (cd $d && mvn clean package); done
```

## Run (in this order)

1. **Start Eureka Server first** and wait until it's fully up:
   ```bash
   cd eureka-server
   mvn spring-boot:run
   ```
   Verify at: http://localhost:8761

2. **Start greet-service**:
   ```bash
   cd greet-service
   mvn spring-boot:run
   ```
   Verify at: http://localhost:8080/greet → should return `Hello World!!`

   Refresh http://localhost:8761 — you should see `GREET-SERVICE` listed under
   "Instances currently registered with Eureka".

3. **Start api-gateway**:
   ```bash
   cd api-gateway
   mvn spring-boot:run
   ```
   Refresh http://localhost:8761 — you should now see `API-GATEWAY` too.

## Test the Gateway Routing

Access greet-service through the gateway (note: lower-case service id is enabled):

```
http://localhost:9090/greet-service/greet
```

You should see `Hello World!!` in the browser, and in the **api-gateway console**
you should see a log line similar to:

```
====>Request URL http://localhost:9090/greet-service/greet
```

This confirms the `LogFilter` global filter (in
`api-gateway/src/main/java/com/cts/gateway/filters/LogFilter.java`) is
intercepting and logging every request that passes through the gateway.

## Project Structure

```
microservices/
├── eureka-server/
│   ├── pom.xml
│   └── src/main/java/com/example/eurekaserver/EurekaServerApplication.java
│   └── src/main/resources/application.properties
├── greet-service/
│   ├── pom.xml
│   └── src/main/java/com/cts/greet/GreetServiceApplication.java
│   └── src/main/java/com/cts/greet/controller/GreetController.java
│   └── src/main/resources/application.properties
└── api-gateway/
    ├── pom.xml
    └── src/main/java/com/cts/gateway/ApiGatewayApplication.java
    └── src/main/java/com/cts/gateway/filters/LogFilter.java
    └── src/main/resources/application.properties
```

## Notes

- These projects were **not compiled in this environment** (no access to Maven
  Central here), so run `mvn clean package` locally before running them — Maven
  will download all dependencies automatically.
- Spring Boot version: 2.5.5, Spring Cloud version: 2020.0.4 (matches the
  versions referenced in the original exercise). If you'd prefer newer
  versions, update `<parent><version>` and `<spring-cloud.version>` in each
  `pom.xml` to compatible values.
