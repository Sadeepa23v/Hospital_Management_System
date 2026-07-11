package com.hospital_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "patient_id")
        private Integer patientId;

        @Column(name = "first_name")
        private String firstName;

        @Column(name = "last_name")
        private String lastName;

        @Column(name = "date_of_birth")
        private LocalDate dateOfBirth;

        private String gender;

        private String phone;

        private String email;

        private String address;
    }
