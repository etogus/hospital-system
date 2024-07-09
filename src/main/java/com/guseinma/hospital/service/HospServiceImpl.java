package com.guseinma.hospital.service;

import com.guseinma.hospital.factory.HospitalFactory;
import com.guseinma.hospital.proto.*;
import com.guseinma.hospital.repository.HospitalRepository;
import com.guseinma.hospital.repository.PatientRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HospServiceImpl implements HospService {
    @Autowired
    private HospitalRepository hospitalRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void createHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        try {
            com.guseinma.hospital.model.Hospital hospital = HospitalFactory.createFromRequest(request);
            hospitalRepository.save(hospital);
            hospitalRepository.flush();
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error creating hospital: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    public void updateHospital(Hospital request, StreamObserver<OperationResponse> streamObserver) {
        try {
            com.guseinma.hospital.model.Hospital hospital = hospitalRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Hospital does not exist!"));
            HospitalFactory.updateFromRequest(hospital, request);
            hospitalRepository.save(hospital);
            hospitalRepository.flush();
            OperationResponse operationResponse = OperationResponse.newBuilder()
                    .setSuccess(true)
                    .build();
            streamObserver.onNext(operationResponse);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error updating hospital: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    @Transactional
    public void deleteHospital(HospitalId request, StreamObserver<OperationResponse> streamObserver) {
        try {
            Optional<com.guseinma.hospital.model.Hospital> optionalHospital = hospitalRepository
                    .findById(request.getId());
            if(optionalHospital.isPresent()) {
                com.guseinma.hospital.model.Hospital hospital = optionalHospital.get();
                // Remove the hospital from all patients who registered in it
                for(com.guseinma.hospital.model.Patient patient: hospital.getPatients()) {
                    patient.getHospitals().remove(hospital);
                    patientRepository.save(patient);
                }

                hospital.getPatients().clear();
                hospitalRepository.save(hospital);
                hospitalRepository.delete(hospital);
                hospitalRepository.flush();

                OperationResponse operationResponse = OperationResponse.newBuilder()
                        .setSuccess(true)
                        .build();
                streamObserver.onNext(operationResponse);
                streamObserver.onCompleted();
            } else {
                throw new RuntimeException("Hospital does not exist!");
            }
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error deleting hospital: " + e.getMessage())
                    .asRuntimeException());
        }
    }

    @Override
    @Transactional
    public void readPatientsOfHospital(HospitalId request, StreamObserver<PatientList> streamObserver) {
        try {
            com.guseinma.hospital.model.Hospital hospital = hospitalRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Hospital does not exist!"));
            List<Patient> patients = hospital.getPatients().stream()
                    .map(this::patientToProto).toList();
            PatientList patientList = PatientList.newBuilder()
                    .addAllPatients(patients)
                    .build();
            streamObserver.onNext(patientList);
            streamObserver.onCompleted();
        } catch (Exception e) {
            streamObserver.onError(Status.INTERNAL
                    .withDescription("Error processing readPatientsOfHospital: " + e.getMessage())
                    .asRuntimeException());
        }
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
