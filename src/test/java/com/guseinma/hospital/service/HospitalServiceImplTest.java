package com.guseinma.hospital.service;

import com.guseinma.hospital.proto.*;
import com.guseinma.hospital.repository.HospitalRepository;
import com.guseinma.hospital.repository.PatientRepository;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

class HospitalServiceImplTest {

    @Mock
    private HospitalRepository hospitalRepository;
    @Mock
    private PatientRepository patientRepository;
    @InjectMocks
    private HospitalServiceImpl hospitalService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createHospital() {
        Hospital hospital = Hospital.newBuilder()
                .setName("Hospital 1")
                .setAddress("1 Test St")
                .setPhoneNumber("123-456-7890")
                .build();
        StreamObserver<OperationResponse> streamObserver = mock(StreamObserver.class);

        hospitalService.createHospital(hospital, streamObserver);

        verify(hospitalRepository).save(any(com.guseinma.hospital.model.Hospital.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void createPatient() {
        Patient patient = Patient.newBuilder()
                .setFirstName("Jackie")
                .setLastName("Chan")
                .setGender("Male")
                .setBirthDate("1954-04-07")
                .setPhoneNumber("999-888-7654")
                .build();
        StreamObserver<OperationResponse> streamObserver = mock(StreamObserver.class);

        hospitalService.createPatient(patient, streamObserver);

        verify(patientRepository).save(any(com.guseinma.hospital.model.Patient.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void registerPatient() {
        RegisterRequest registerRequest = RegisterRequest.newBuilder()
                .setHospitalId(1L)
                .setPatientId(1L)
                .build();
        StreamObserver<OperationResponse> streamObserver = mock(StreamObserver.class);
        com.guseinma.hospital.model.Hospital hospital = new com.guseinma.hospital.model.Hospital();
        hospital.setId(1L);
        hospital.setPatients(new ArrayList<>());
        com.guseinma.hospital.model.Patient patient = new com.guseinma.hospital.model.Patient();
        patient.setId(1L);
        patient.setHospitals(new ArrayList<>());

        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));
        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        hospitalService.registerPatient(registerRequest, streamObserver);

        verify(patientRepository).save(any(com.guseinma.hospital.model.Patient.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void deleteHospital() {
        HospitalId hospitalId = HospitalId.newBuilder()
                .setId(1L)
                .build();
        StreamObserver<OperationResponse> streamObserver = mock(StreamObserver.class);
        com.guseinma.hospital.model.Hospital hospital = new com.guseinma.hospital.model.Hospital();
        hospital.setId(1L);
        hospital.setPatients(new ArrayList<>());

        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));

        hospitalService.deleteHospital(hospitalId, streamObserver);

        verify(hospitalRepository).delete(hospital);
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void updatePatient() {
        com.guseinma.hospital.model.Patient patient = new com.guseinma.hospital.model.Patient();
        patient.setId(1L);
        Patient updatedPatient = Patient.newBuilder()
                .setId(1L)
                .setFirstName("Not Jackie")
                .setLastName("Totally not Chan")
                .setGender("Female")
                .setBirthDate("1954-04-07")
                .setPhoneNumber("999-888-7654")
                .build();
        StreamObserver<OperationResponse> streamObserver = mock(StreamObserver.class);

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        hospitalService.updatePatient(updatedPatient, streamObserver);

        verify(patientRepository).save(any(com.guseinma.hospital.model.Patient.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void readPatientsOfHospital() {
        HospitalId hospitalId = HospitalId.newBuilder().setId(1L).build();
        StreamObserver<PatientList> streamObserver = mock(StreamObserver.class);
        com.guseinma.hospital.model.Hospital hospital = new com.guseinma.hospital.model.Hospital();
        hospital.setId(1L);
        com.guseinma.hospital.model.Patient patient = new com.guseinma.hospital.model.Patient();
        patient.setId(1L);
        patient.setFirstName("Jackie");
        patient.setLastName("Chan");
        patient.setBirthDate(LocalDate.of(1954, 4, 7));
        patient.setGender("Male");
        patient.setPhoneNumber("999-888-7654");
        hospital.setPatients(new ArrayList<>());
        hospital.getPatients().add(patient);

        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));

        hospitalService.readPatientsOfHospital(hospitalId, streamObserver);
        verify(streamObserver).onNext(any(PatientList.class));
        verify(streamObserver).onCompleted();
    }


}