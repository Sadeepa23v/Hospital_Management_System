package com.hospital_management_system.service;

import com.hospital_management_system.dto.DoctorDTO;
import com.hospital_management_system.entity.Doctor;
import com.hospital_management_system.mapper.DoctorMapper;
import com.hospital_management_system.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<DoctorDTO> getDoctorById(Long id) {

        return doctorRepository.findById(id)
                .map(DoctorMapper::toDTO);
    }


    public DoctorDTO saveDoctor(DoctorDTO doctorDTO) {

        Doctor doctor = DoctorMapper.toEntity(doctorDTO);

        Doctor savedDoctor = doctorRepository.save(doctor);

        return DoctorMapper.toDTO(savedDoctor);
    }


    public void deleteDoctor(Long id) {

        doctorRepository.deleteById(id);
    }

}