package com.guseinma.hospital.client;

import com.guseinma.hospital.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        HospitalServiceGrpc.HospitalServiceBlockingStub stub
                = HospitalServiceGrpc.newBlockingStub(channel);

        // Create Hospital
        Hospital hospital = Hospital.newBuilder()
                .setName("Grpc Test Hospital")
                .setAddress("789 Grpc St")
                .setPhoneNumber("111-222-3333")
                .build();

        OperationResponse response = stub.createHospital(hospital);
        System.out.println("Create Hospital Response: " + response.getSuccess());

        // Create Patient
        Patient patient = Patient.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setBirthDate("1990-01-01")
                .setPhoneNumber("444-555-6666")
                .build();

        response = stub.createPatient(patient);
        System.out.println("Create Patient Response: " + response.getSuccess());

        // Read Patients of Hospital (before registering)
        HospitalId hospitalId = HospitalId.newBuilder().setId(1L).build();
        PatientList patientList = stub.readPatientsOfHospital(hospitalId);
        System.out.println("Patients in Hospital before registration: " + patientList.getPatientsCount());

        // Register Patient to Hospital
        RegisterRequest registerRequest = RegisterRequest.newBuilder()
                .setPatientId(1L)
                .setHospitalId(1L)
                .build();
        response = stub.registerPatient(registerRequest);
        System.out.println("Register Patient Response: " + response.getSuccess());

        // Read Patients of Hospital (after registration)
        patientList = stub.readPatientsOfHospital(hospitalId);
        System.out.println("Patients in Hospital after registration: " + patientList.getPatientsCount());

        channel.shutdown();
    }
}