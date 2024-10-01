# Hospital system
This project is a hospital system defined in Grpc using Spring Boot with Hibernate and JPA that makes it possible to enter and store information about patient treatments.

## Setup
- Java 21
- Spring Boot 3.3.1
- gRPC 1.58.0
- Gradle 8.8

## Building the project
`./gradlew build`

## Running the gRPC Server
`./gradlew bootRun`
<br><br>The gRPC server will start on port 9090 by default.

## Running the gRPC Client
`./gradlew runClient`

## Running the tests
`./gradlew test`
