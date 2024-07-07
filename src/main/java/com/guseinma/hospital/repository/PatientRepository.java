package com.guseinma.hospital.repository;

import com.guseinma.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
