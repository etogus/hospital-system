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
        Hospital hospital1 = Hospital.newBuilder()
                .setName("Grpc Test Hospital 1")
                .setAddress("789 Grpc St")
                .setPhoneNumber("111-222-3333")
                .build();

        OperationResponse response = stub.createHospital(hospital1);
        System.out.println("Create Hospital 1 Response: " + response.getSuccess());

        // Create Patient 1
        Patient patient1 = Patient.newBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setGender("Male")
                .setBirthDate("1990-01-01")
                .setPhoneNumber("444-555-6666")
                .build();

        response = stub.createPatient(patient1);
        System.out.println("Create Patient 1 Response: " + response.getSuccess());

        // Read Patients of Hospital 1 (before registration)
        HospitalId hospitalId1 = HospitalId.newBuilder().setId(1L).build();
        PatientList patientList = stub.readPatientsOfHospital(hospitalId1);
        System.out.println("Patients in Hospital 1 before registration: " + patientList.getPatientsCount());

        // Register Patient 1 to Hospital 1
        RegisterRequest registerRequest = RegisterRequest.newBuilder()
                .setPatientId(1L)
                .setHospitalId(1L)
                .build();
        response = stub.registerPatient(registerRequest);
        System.out.println("Register Patient 1 in Hospital 1 Response: " + response.getSuccess());

        // Read Patients of Hospital 1 (after registration)
        patientList = stub.readPatientsOfHospital(hospitalId1);
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
        registerRequest = RegisterRequest.newBuilder()
                .setPatientId(1L)
                .setHospitalId(2L)
                .build();
        response = stub.registerPatient(registerRequest);
        System.out.println("Register Patient 1 in Hospital 2 Response: " + response.getSuccess());

        // Read Hospitals of Patient 1
        PatientId patientId1 = PatientId.newBuilder().setId(1L).build();
        HospitalList hospitalList = stub.readHospitalsOfPatient(patientId1);
        System.out.println("List of Hospitals of Patient 1: " + hospitalList);

        // Delete Hospital 1
        response = stub.deleteHospital(hospitalId1);
        System.out.println("Hospital 1 has been deleted: " + response.getSuccess());

        // Read Hospitals of Patient 1
        hospitalList = stub.readHospitalsOfPatient(patientId1);
        System.out.println("List of Hospitals of Patient 1: " + hospitalList);

        // Create Patient 2
        Patient patient2 = Patient.newBuilder()
                .setFirstName("Jane")
                .setLastName("Smith")
                .setGender("Female")
                .setBirthDate("2001-05-06")
                .setPhoneNumber("135-246-0000")
                .build();
        response = stub.createPatient(patient2);
        System.out.println("Create Patient 2 Response: " + response.getSuccess());

        // Read Patients of Hospital 2 (before registration)
        HospitalId hospitalId2 = HospitalId.newBuilder().setId(2L).build();
        patientList = stub.readPatientsOfHospital(hospitalId2);
        System.out.println("Patients in Hospital 2 before registration: " + patientList.getPatientsCount());

        // Register Patient 2 to Hospital 2
        registerRequest = RegisterRequest.newBuilder()
                .setPatientId(2L)
                .setHospitalId(2L)
                .build();
        response = stub.registerPatient(registerRequest);
        System.out.println("Register Patient 2 in Hospital 2 Response: " + response.getSuccess());

        // Read Patients of Hospital 2 (after registration)
        patientList = stub.readPatientsOfHospital(hospitalId2);
        System.out.println("Patients in Hospital 2 after registration: " + patientList.getPatientsCount());

        // Delete Patient 2
        PatientId patientId2 = PatientId.newBuilder()
                .setId(2L)
                .build();
        response = stub.deletePatient(patientId2);
        System.out.println("Patient 2 has been deleted: " + response.getSuccess());

        // Read Patients of Hospital 2
        patientList = stub.readPatientsOfHospital(hospitalId2);
        System.out.println("Patients in Hospital 2: " + patientList);

        // Update Patient 1
        patient1 = Patient.newBuilder()
                .setId(1L)
                .setFirstName("Jessica")
                .setLastName("Doe")
                .setGender("Female")
                .setBirthDate("1990-01-01")
                .setPhoneNumber("444-555-6666")
                .build();
        response = stub.updatePatient(patient1);
        System.out.println("Update Patient 1 Response: " + response.getSuccess());

        // Read Patients of Hospital 2 again
        patientList = stub.readPatientsOfHospital(hospitalId2);
        System.out.println("Patients in Hospital 2: " + patientList);

        // Update Hospital 2
        hospital2 = Hospital.newBuilder()
                .setId(2L)
                .setName("New Shiny Name")
                .setAddress("123 Grpc St")
                .setPhoneNumber("999-888-7777")
                .build();
        response = stub.updateHospital(hospital2);
        System.out.println("Update Hospital 2 Response: " + response.getSuccess());

        hospitalList = stub.readHospitalsOfPatient(patientId1);
        System.out.println("List of Hospitals of Patient 1: " + hospitalList);

        channel.shutdown();
    }
}