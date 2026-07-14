package com.hospital_management_system.mapper;

import com.hospital_management_system.dto.DoctorDTO;
import com.hospital_management_system.entity.Doctor;

public class DoctorMapper {

    // Entity -> DTO
    public static DoctorDTO toDTO(Doctor doctor) {

        if (doctor == null) {
            return null;
        }

        DoctorDTO dto = new DoctorDTO();

        // Convert Integer -> Long safely
        Integer entityId = doctor.getDoctorId();
        dto.setDoctorId(entityId == null ? null : entityId.longValue());
        dto.setFirstName(doctor.getFirstName());
        dto.setLastName(doctor.getLastName());
        dto.setSpecialization(doctor.getSpecialization());
        dto.setPhone(doctor.getPhone());
        dto.setEmail(doctor.getEmail());

        return dto;
    }


    // DTO -> Entity
    public static Doctor toEntity(DoctorDTO dto) {

        if (dto == null) {
            return null;
        }

        Doctor doctor = new Doctor();

        // Convert Long -> Integer safely (watch for potential overflow)
        Long dtoId = dto.getDoctorId();
        doctor.setDoctorId(dtoId == null ? null : dtoId.intValue());
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setPhone(dto.getPhone());
        doctor.setEmail(dto.getEmail());

        return doctor;
    }
}