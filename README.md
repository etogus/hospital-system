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

## Sample gRPC Client output

<details>
<summary>Click to expand/collapse</summary>

> Task :GrpcClient.main()<br>
> Create Hospital 1 Response: true<br>
> Create Patient 1 Response: true<br>
> Patients in Hospital 1 before registration: 0<br>
> Register Patient 1 in Hospital 1 Response: true<br>
> Patients in Hospital 1 after registration: 1<br>
> Create Hospital 2 Response: true<br>
> Register Patient 1 in Hospital 2 Response: true<br>
> List of Hospitals of Patient 1: hospitals {<br>
>   id: 1<br>
>   name: "Grpc Test Hospital 1"<br>
>   address: "789 Grpc St"<br>
>   phoneNumber: "111-222-3333"<br>
> }<br>
> hospitals {<br>
>   id: 2<br>
>   name: "Grpc Test Hospital 2"<br>
>   address: "123 Grpc St"<br>
>   phoneNumber: "999-888-7777"<br>
> }<br>

> Hospital 1 has been deleted: true<br>
> List of Hospitals of Patient 1: hospitals {<br>
>   id: 2<br>
>   name: "Grpc Test Hospital 2"<br>
>   address: "123 Grpc St"<br>
>   phoneNumber: "999-888-7777"<br>
> }<br>

> Create Patient 2 Response: true<br>
> Patients in Hospital 2 before registration: 1<br>
> Register Patient 2 in Hospital 2 Response: true<br>
> Patients in Hospital 2 after registration: 2<br>
> Patient 2 has been deleted: true<br>
> Patients in Hospital 2: patients {<br>
>   id: 1<br>
>   first_name: "John"<br>
>   last_name: "Doe"<br>
>   gender: "Male"<br>
>   birth_date: "1990-01-01"<br>
>   phone_number: "444-555-6666"<br>
> }<br>

> Update Patient 1 Response: true<br>
> Patients in Hospital 2: patients {<br>
>   id: 1<br>
>   first_name: "Jessica"<br>
>   last_name: "Doe"<br>
>   gender: "Female"<br>
>   birth_date: "1990-01-01"<br>
>   phone_number: "444-555-6666"<br>
> }<br>

> Update Hospital 2 Response: true<br>
> List of Hospitals of Patient 1: hospitals {<br>
>   id: 2<br>
>   name: "New Shiny Name"<br>
>   address: "123 Grpc St"<br>
>   phoneNumber: "999-888-7777"<br>
> }
</details>
