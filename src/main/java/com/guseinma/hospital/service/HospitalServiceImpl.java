package com.guseinma.hospital.service;


import com.guseinma.hospital.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class HospitalServiceImpl extends HospitalServiceGrpc.HospitalServiceImplBase {
    @Autowired
    private HospService hospService;
    @Autowired
    private PatientService patientService;

    @Override
    public void createHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        hospService.createHospital(request, streamObserver);
    }

    @Override
    public void updateHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        hospService.updateHospital(request, streamObserver);
    }

    @Override
    public void deleteHospital(HospitalId request, StreamObserver<OperationResponse> streamObserver) {
        hospService.deleteHospital(request, streamObserver);
    }

    @Override
    public void createPatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        patientService.createPatient(request, streamObserver);
    }

    @Override
    public void updatePatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        patientService.updatePatient(request, streamObserver);
    }

    @Override
    public void deletePatient(PatientId request, StreamObserver<OperationResponse> streamObserver) {
        patientService.deletePatient(request, streamObserver);
    }

    @Override
    public void registerPatient(RegisterRequest request, StreamObserver<OperationResponse> streamObserver) {
        patientService.registerPatient(request, streamObserver);
    }

    @Override
    public void readPatientsOfHospital(HospitalId request, StreamObserver<PatientList> streamObserver) {
        hospService.readPatientsOfHospital(request, streamObserver);
    }

    @Override
    public void readHospitalsOfPatient(PatientId request, StreamObserver<HospitalList> streamObserver) {
        patientService.readHospitalsOfPatient(request, streamObserver);
    }
}
