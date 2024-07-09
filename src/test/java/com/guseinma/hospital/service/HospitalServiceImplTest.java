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


}