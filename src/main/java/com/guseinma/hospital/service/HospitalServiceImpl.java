package com.guseinma.hospital.service;


import com.guseinma.hospital.proto.*;
import com.guseinma.hospital.repository.HospitalRepository;
import com.guseinma.hospital.repository.PatientRepository;
import io.grpc.stub.StreamObserver;
import jakarta.transaction.Transactional;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

@GrpcService
public class HospitalServiceImpl extends HospitalServiceGrpc.HospitalServiceImplBase {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void createHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        com.guseinma.hospital.model.Hospital hospital = new com.guseinma.hospital.model.Hospital();
        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());
        hospitalRepository.save(hospital);
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    public void updateHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        com.guseinma.hospital.model.Hospital hospital = hospitalRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Hospital does not exist!"));
        hospital.setName(request.getName());
        hospital.setAddress(request.getAddress());
        hospital.setPhoneNumber(request.getPhoneNumber());
        hospitalRepository.save(hospital);
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    public void deleteHospital(HospitalId request, StreamObserver<OperationResponse> streamObserver) {
        hospitalRepository.deleteById(request.getId());
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    public void createPatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        com.guseinma.hospital.model.Patient patient = new com.guseinma.hospital.model.Patient();
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setBirthDate(LocalDate.parse(request.getBirthDate()));
        patient.setPhoneNumber(request.getPhoneNumber());
        patientRepository.save(patient);
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    public void updatePatient(Patient request, StreamObserver<OperationResponse> streamObserver) {
        com.guseinma.hospital.model.Patient patient = patientRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Patient does not exist!"));
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setBirthDate(LocalDate.parse(request.getBirthDate()));
        patient.setPhoneNumber(request.getPhoneNumber());
        patientRepository.save(patient);
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    public void deletePatient(PatientId request, StreamObserver<OperationResponse> streamObserver) {
        patientRepository.deleteById(request.getId());
        OperationResponse operationResponse = OperationResponse.newBuilder()
                .setSuccess(true)
                .build();
        streamObserver.onNext(operationResponse);
        streamObserver.onCompleted();
    }

    @Override
    @Transactional
    public void registerPatient(RegisterRequest request, StreamObserver<OperationResponse> streamObserver) {
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
    }

    @Override
    public void readPatientsOfHospital(HospitalId request, StreamObserver<PatientList> streamObserver) {
        com.guseinma.hospital.model.Hospital hospital = hospitalRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Hospital does not exist!"));
        List<Patient> patients = hospital.getPatients().stream()
                .map(this::patientToProto).toList();
        PatientList patientList = PatientList.newBuilder()
                .addAllPatients(patients)
                .build();
        streamObserver.onNext(patientList);
        streamObserver.onCompleted();
    }

    @Override
    public void readHospitalsOfPatient(PatientId request, StreamObserver<HospitalList> streamObserver) {
        com.guseinma.hospital.model.Patient patient = patientRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Patient does not exist!"));
        List<Hospital> hospitals = patient.getHospitals().stream()
                .map(this::hospitalToProto).toList();
        HospitalList hospitalList = HospitalList.newBuilder()
                .addAllHospitals(hospitals)
                .build();
        streamObserver.onNext(hospitalList);
        streamObserver.onCompleted();
    }

    private Hospital hospitalToProto(com.guseinma.hospital.model.Hospital hospital) {
        return Hospital.newBuilder()
                .setId(hospital.getId())
                .setName(hospital.getName())
                .setAddress(hospital.getAddress())
                .setPhoneNumber(hospital.getPhoneNumber())
                .build();
    }

    private Patient patientToProto(com.guseinma.hospital.model.Patient patient) {
        return Patient.newBuilder()
                .setId(patient.getId())
                .setFirstName(patient.getFirstName())
                .setLastName(patient.getLastName())
                .setGender(patient.getGender())
                .setBirthDate(patient.getBirthDate().toString())
                .setPhoneNumber(patient.getPhoneNumber())
                .build();
    }
}
