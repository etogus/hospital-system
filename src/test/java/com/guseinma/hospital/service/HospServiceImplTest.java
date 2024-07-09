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

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

class HospServiceImplTest {

    @Mock
    private HospitalRepository hospitalRepository;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private StreamObserver<OperationResponse> streamObserver;

    @Mock
    private StreamObserver<PatientList> patientListObserver;

    @InjectMocks
    private HospServiceImpl hospService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createHospital() {
        Hospital request = Hospital.newBuilder()
                .setName("Hospital 1")
                .setAddress("123 St")
                .setPhoneNumber("12345")
                .build();

        hospService.createHospital(request, streamObserver);

        verify(hospitalRepository).save(any(com.guseinma.hospital.model.Hospital.class));
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void updateHospital() {
        Hospital request = Hospital.newBuilder()
                .setId(1L)
                .setName("Updated Name")
                .setAddress("Updated Address")
                .setPhoneNumber("09876")
                .build();

        com.guseinma.hospital.model.Hospital existingHospital = new com.guseinma.hospital.model.Hospital();
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(existingHospital));

        hospService.updateHospital(request, streamObserver);

        verify(hospitalRepository).save(existingHospital);
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void deleteHospital() {
        HospitalId request = HospitalId.newBuilder().setId(1L).build();

        com.guseinma.hospital.model.Hospital existingHospital = new com.guseinma.hospital.model.Hospital();
        existingHospital.setPatients(new ArrayList<>());
        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(existingHospital));

        hospService.deleteHospital(request, streamObserver);

        verify(hospitalRepository).delete(existingHospital);
        verify(streamObserver).onNext(any(OperationResponse.class));
        verify(streamObserver).onCompleted();
    }

    @Test
    void readPatientsOfHospital() {
        HospitalId request = HospitalId.newBuilder().setId(1L).build();

        com.guseinma.hospital.model.Hospital hospital = new com.guseinma.hospital.model.Hospital();
        com.guseinma.hospital.model.Patient patient = new com.guseinma.hospital.model.Patient();
        patient.setId(1L);
        patient.setFirstName("Jackie");
        patient.setLastName("Chan");
        patient.setGender("Male");
        patient.setBirthDate(java.time.LocalDate.of(1990, 1, 1));
        patient.setPhoneNumber("111222");
        hospital.getPatients().add(patient);

        when(hospitalRepository.findById(1L)).thenReturn(Optional.of(hospital));

        hospService.readPatientsOfHospital(request, patientListObserver);

        verify(patientListObserver).onNext(any(PatientList.class));
        verify(patientListObserver).onCompleted();
    }
}