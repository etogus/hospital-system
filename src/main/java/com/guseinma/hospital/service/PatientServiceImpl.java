package com.guseinma.hospital.service;

import com.guseinma.hospital.factory.PatientFactory;
import com.guseinma.hospital.proto.*;
import com.guseinma.hospital.repository.HospitalRepository;
import com.guseinma.hospital.repository.PatientRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void createPatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        try {
            com.guseinma.hospital.model.Patient patient = PatientFactory.createFromRequest(request);
            patientRepository.save(patient);
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error creating patient: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updatePatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        try {
            com.guseinma.hospital.model.Patient patient = patientRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Patient does not exist!"));
            PatientFactory.updateFromRequest(patient, request);
            patientRepository.save(patient);
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error updating patient: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void deletePatient(PatientId request, StreamObserver<OperationResponse> streamObserver) {
        try {
            patientRepository.deleteById(request.getId());
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error deleting patient: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    @Transactional
    public void registerPatient(RegisterRequest request, StreamObserver<OperationResponse> streamObserver) {
        try {
            com.guseinma.hospital.model.Patient patient = patientRepository.findById(request.getPatientId())
                    .orElseThrow(() -> new RuntimeException("Patient does not exist!"));
            com.guseinma.hospital.model.Hospital hospital = hospitalRepository.findById(request.getHospitalId())
                    .orElseThrow(() -> new RuntimeException("Hospital does not exist!"));
            patient.getHospitals().add(hospital);
            patientRepository.save(patient);
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error processing registerPatient: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    @Transactional
    public void readHospitalsOfPatient(PatientId request, StreamObserver<HospitalList> streamObserver) {
        try {
            com.guseinma.hospital.model.Patient patient = patientRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Patient does not exist!"));
            List<Hospital> hospitals = patient.getHospitals().stream()
                    .map(this::hospitalToProto).toList();
            HospitalList hospitalList = HospitalList.newBuilder()
                    .addAllHospitals(hospitals)
                    .build();
            streamObserver.onNext(hospitalList);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error processing readHospitalsOfPatient: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    private Hospital hospitalToProto(com.guseinma.hospital.model.Hospital hospital) {
        return Hospital.newBuilder()
                .setId(hospital.getId())
                .setName(hospital.getName())
                .setAddress(hospital.getAddress())
                .setPhoneNumber(hospital.getPhoneNumber())
                .build();
    }
}
