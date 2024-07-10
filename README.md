## Special request solution
<details>
<summary>Click to expand/collapse</summary>
  
1. Add the new method to the .proto file:
```
service HospitalService {
  …
  rpc GetAverageAge (AverageAgeRequest) returns (AverageAgeResponse) {}
  …
}
…
message AverageAgeRequest {
    int32 start_year = 1;
    int32 end_year = 2;
}

message AverageAgeResponse {
    repeated PatientAvgAgeData data = 1;
}

message PatientAvgAgeData {
    int32 year = 1;
    int32 month = 2;
    string sex = 3;
    double average_age = 4;
    int32 patient_count = 5;
}
```
2. Use a distributed database system for storing patient data e.g. Cassandra instead of H2.

3. Create a model for patient-age info:
```
@Entity
public class PatientAge {
    private int year;
    private int month;
    private String sex;
    private double averageAge;
    private int patientCount;
    …
}
```
4. Create a service to handle database operations for writing and reading data:
```
@Service
public class AggregatedDataService {
  …
  public void aggregateData(int _year, int _month) {
          String sql =
              "INSERT INTO patient_age (year, month, sex, average_age, patient_count) " +
              "SELECT _year AS year, _month AS month, sex, AVG(age) AS average_age, COUNT(*) AS patient_count " +
              "FROM patients WHERE year = _year AND month = _month GROUP BY sex";
          …
  }

  public List<PatientAge> getAggregatedData(int startYear, int endYear) {
          String sql =
              "SELECT year, month, sex, avg_age, patient_count " +
              "FROM patient_age WHERE year >= startYear AND year <= endYear"
          …
  }
…
}
```
5. Create a service to run aggregation process periodically:
```
@Service
public class AggregationService {
  @Autowired
  private AggregatedDataService aggregatedDataService;

  @Scheduled
      public void aggregateDataDaily() {
          LocalDate localDate = LocalDate.now();
          aggregatedDataService.aggregateData(localDate.getYear(), localDate.getMonth());
          …
      }
  …
}
```
6. Add the new method to GrpcService:
 ```
@GrpcService
public class HospitalServiceImpl extends HospitalServiceGrpc.HospitalServiceImplBase {
    …
    @Autowired
    private AggregatedDataService aggregatedDataService;

    @Override
    public void getAverageAge(AverageAgeRequest request,
                                           StreamObserver<AverageAgeResponse> responseObserver) {
        List<PatientAge> data = aggregatedDataService.getAverageAgeStats(
            request.getStartYear(), request.getEndYear()); 
        …
        responseObserver.onNext(response);
        responseObserver.onCompleted();
   }
  …
}
```
</details>

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
