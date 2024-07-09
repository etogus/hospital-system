package com.guseinma.hospital.service;

import com.guseinma.hospital.model.Hospital;
import com.guseinma.hospital.model.Patient;
import com.guseinma.hospital.proto.*;
import com.guseinma.hospital.repository.HospitalRepository;
import com.guseinma.hospital.repository.PatientRepository;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class PatientServiceImplTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private HospitalRepository hospitalRepository;

    @Mock
    private StreamObserver<OperationResponse> streamObserver;

    @Mock
    private StreamObserver<HospitalList> hospitalListObserver;

    @InjectMocks
    private PatientServiceImpl patientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createPatient() {
        com.guseinma.hospital.proto.Patient patient = com.guseinma.hospital.proto.Patient.newBuilder()
                .setFirstName("Jackie")
                .setLastName("Chan")
                .setGender("Male")
                .setBirthDate("1954-04-07")
                .setPhoneNumber("111-222-3333")
                .build();

        patientService.createPatient(patient, streamObserver);

        verify(patientRepository).save(any(Patient.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void updatePatient() {
        com.guseinma.hospital.proto.Patient patient = com.guseinma.hospital.proto.Patient.newBuilder()
                .setId(1L)
                .setFirstName("Updated Jackie")
                .setLastName("Updated Chan")
                .setGender("Female")
                .setBirthDate("1954-04-07")
                .setPhoneNumber("111-222-3333")
                .build();

        Patient existingPatient = new Patient();
        existingPatient.setId(1L);

        when(patientRepository.findById(1L)).thenReturn(Optional.of(existingPatient));

        patientService.updatePatient(patient, streamObserver);

        verify(patientRepository).save(any(Patient.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void deletePatient() {
        PatientId patientId = PatientId.newBuilder().setId(1L).build();

        patientService.deletePatient(patientId, streamObserver);

        verify(patientRepository).deleteById(1L);
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void readHospitalsOfPatient() {
        PatientId patientId = PatientId.newBuilder().setId(1L).build();

        Patient patient = new Patient();
        patient.setId(1L);
        Hospital hospital = new Hospital();
        hospital.setId(1L);
        hospital.setName("Hospital 1");
        hospital.setAddress("123 St");
        hospital.setPhoneNumber("999-888-7777");
        patient.setHospitals(new ArrayList<>());
        patient.getHospitals().add(hospital);

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        patientService.readHospitalsOfPatient(patientId, hospitalListObserver);

        verify(hospitalListObserver).onNext(any(HospitalList.class));
        verify(hospitalListObserver).onCompleted();
    }
}
