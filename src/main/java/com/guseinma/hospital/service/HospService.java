package com.guseinma.hospital.service;

import com.guseinma.hospital.proto.Hospital;
import com.guseinma.hospital.proto.HospitalId;
import com.guseinma.hospital.proto.OperationResponse;
import com.guseinma.hospital.proto.PatientList;
import io.grpc.stub.StreamObserver;

public interface HospService {
    void createHospital(Hospital request, StreamObserver<OperationResponse> streamObserver);
    void updateHospital(Hospital request, StreamObserver<OperationResponse> streamObserver);
    void deleteHospital(HospitalId request, StreamObserver<OperationResponse> streamObserver);
    void readPatientsOfHospital(HospitalId request, StreamObserver<PatientList> streamObserver);
}
