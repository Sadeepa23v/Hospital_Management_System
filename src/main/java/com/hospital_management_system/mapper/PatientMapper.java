package com.hospital_management_system.mapper;

import com.hospital_management_system.dto.PatientDTO;
import com.hospital_management_system.entity.Patient;

public class PatientMapper {

    // Convert Entity -> DTO
    public static PatientDTO toDTO(Patient patient) {

        PatientDTO dto = new PatientDTO();

        // convert Integer (entity) -> Long (dto) safely
        dto.setPatientId(patient.getPatientId() == null ? null : patient.getPatientId().longValue());
        dto.setFirstName(patient.getFirstName());
        dto.setLastName(patient.getLastName());
        dto.setDateOfBirth(patient.getDateOfBirth());
        dto.setGender(patient.getGender());
        dto.setPhone(patient.getPhone());
        dto.setEmail(patient.getEmail());
        dto.setAddress(patient.getAddress());

        return dto;
    }


    // Convert DTO -> Entity
    public static Patient toEntity(PatientDTO dto) {

        Patient patient = new Patient();

        // convert Long (dto) -> Integer (entity) safely (may truncate if out of Integer range)
        patient.setPatientId(dto.getPatientId() == null ? null : dto.getPatientId().intValue());
        patient.setFirstName(dto.getFirstName());
        patient.setLastName(dto.getLastName());
        patient.setDateOfBirth(dto.getDateOfBirth());
        patient.setGender(dto.getGender());
        patient.setPhone(dto.getPhone());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());

        return patient;
    }
}