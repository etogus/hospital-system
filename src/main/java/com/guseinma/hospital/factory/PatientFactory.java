package com.guseinma.hospital.factory;

import com.guseinma.hospital.model.Patient;

import java.time.LocalDate;

public class PatientFactory {
    public static Patient createFromRequest(com.guseinma.hospital.proto.Patient request) {
        Patient patient = new Patient();
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setBirthDate(LocalDate.parse(request.getBirthDate()));
        patient.setPhoneNumber(request.getPhoneNumber());
        return patient;
    }

    public static void updateFromRequest(Patient patient, com.guseinma.hospital.proto.Patient request) {
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setGender(request.getGender());
        patient.setBirthDate(LocalDate.parse(request.getBirthDate()));
        patient.setPhoneNumber(request.getPhoneNumber());
    }
}
