package com.guseinma.hospital.service;

import com.guseinma.hospital.proto.*;
import io.grpc.stub.StreamObserver;

public interface PatientService {
    void createPatient(Patient request, StreamObserver<OperationResponse> streamObserver);
    void updatePatient(Patient request, StreamObserver<OperationResponse> streamObserver);
    void deletePatient(PatientId request, StreamObserver<OperationResponse> streamObserver);
    void registerPatient(RegisterRequest request, StreamObserver<OperationResponse> streamObserver);
    void readHospitalsOfPatient(PatientId request, StreamObserver<HospitalList> streamObserver);
}
