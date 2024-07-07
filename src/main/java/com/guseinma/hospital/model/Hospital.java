package com.guseinma.hospital.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;

    @ManyToMany(mappedBy = "hospitals")
    private Set<Patient> patients = new HashSet<>();
}
