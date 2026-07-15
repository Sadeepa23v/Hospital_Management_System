package com.hospital_management_system.service;

import com.hospital_management_system.dto.DoctorDTO;
import com.hospital_management_system.entity.Doctor;
import com.hospital_management_system.exception.ResourceNotFoundException;
import com.hospital_management_system.mapper.DoctorMapper;
import com.hospital_management_system.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;


    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }


    public List<DoctorDTO> getAllDoctors() {

        return doctorRepository.findAll()
                .stream()
                .map(DoctorMapper::toDTO)
                .toList();
    }


    public DoctorDTO getDoctorById(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with id: " + id
                        )
                );

        return DoctorMapper.toDTO(doctor);
    }


    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = DoctorMapper.toEntity(doctorDTO);

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorMapper.toDTO(savedDoctor);
    }


    public void deleteDoctor(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with id: " + id
                        )
                );

        doctorRepository.delete(doctor);
    }

}