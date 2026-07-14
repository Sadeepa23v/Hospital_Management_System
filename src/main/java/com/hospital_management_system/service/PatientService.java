package com.hospital_management_system.service;

import com.hospital_management_system.dto.PatientDTO;
import com.hospital_management_system.entity.Patient;
import com.hospital_management_system.mapper.PatientMapper;
import com.hospital_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


    private final PatientRepository patientRepository;


    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    public List<PatientDTO> getAllPatients() {

        return patientRepository.findAll()
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }


    public Optional<PatientDTO> getPatientById(Long id) {

        return patientRepository.findById(id)
                .map(PatientMapper::toDTO);
    }


    public PatientDTO savePatient(PatientDTO patientDTO) {

        Patient patient = PatientMapper.toEntity(patientDTO);

        Patient savedPatient = patientRepository.save(patient);

        return PatientMapper.toDTO(savedPatient);
    }


    public void deletePatient(Long id) {

        patientRepository.deleteById(id);
    }

}