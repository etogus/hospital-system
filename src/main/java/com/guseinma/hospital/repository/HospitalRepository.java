package com.guseinma.hospital.repository;

import com.guseinma.hospital.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
