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

        // Create Hospital 1
        Hospital hospital = Hospital.newBuilder()
                .setName("Grpc Test Hospital 1")
                .setAddress("789 Grpc St")
                .setPhoneNumber("111-222-3333")
                .build();

        OperationResponse response = stub.createHospital(hospital);
        System.out.println("Create Hospital 1 Response: " + response.getSuccess());

        // Create Patient 1
        Patient patient = Patient.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setBirthDate("1990-01-01")
                .setPhoneNumber("444-555-6666")
                .build();

        response = stub.createPatient(patient);
        System.out.println("Create Patient 1 Response: " + response.getSuccess());

        // Read Patients of Hospital 1 (before registration)
        HospitalId hospitalId = HospitalId.newBuilder().setId(1L).build();
        PatientList patientList = stub.readPatientsOfHospital(hospitalId);
        System.out.println("Patients in Hospital 1 before registration: " + patientList.getPatientsCount());

        // Register Patient 1 to Hospital
        RegisterRequest registerRequest = RegisterRequest.newBuilder()
                .setPatientId(1L)
                .setHospitalId(1L)
                .build();
        response = stub.registerPatient(registerRequest);
        System.out.println("Register Patient 1 in Hospital 1 Response: " + response.getSuccess());

        // Read Patients of Hospital 1 (after registration)
        patientList = stub.readPatientsOfHospital(hospitalId);
        System.out.println("Patients in Hospital 1 after registration: " + patientList.getPatientsCount());

        // Create Hospital 2
        Hospital hospital2 = Hospital.newBuilder()
                .setName("Grpc Test Hospital 2")
                .setAddress("123 Grpc St")
                .setPhoneNumber("999-888-7777")
                .build();

        response = stub.createHospital(hospital2);
        System.out.println("Create Hospital 2 Response: " + response.getSuccess());

        // Register Patient 1 to Hospital 2
        RegisterRequest registerRequest2 = RegisterRequest.newBuilder()
                .setPatientId(1L)
                .setHospitalId(2L)
                .build();
        response = stub.registerPatient(registerRequest2);
        System.out.println("Register Patient 1 in Hospital 2 Response: " + response.getSuccess());

        PatientId patientId = PatientId.newBuilder().setId(1L).build();
        HospitalList hospitalList = stub.readHospitalsOfPatient(patientId);
        System.out.println("List of Hospitals of Patient 1: " + hospitalList);

        channel.shutdown();
    }
}