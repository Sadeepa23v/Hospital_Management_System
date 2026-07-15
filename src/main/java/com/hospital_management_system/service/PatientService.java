package com.hospital_management_system.service;

import com.hospital_management_system.dto.PatientDTO;
import com.hospital_management_system.entity.Patient;
import com.hospital_management_system.exception.ResourceNotFoundException;
import com.hospital_management_system.mapper.PatientMapper;
import com.hospital_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public PatientDTO getPatientById(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with id: " + id
                        )
                );

        return PatientMapper.toDTO(patient);
    }


    public PatientDTO savePatient(PatientDTO patientDTO) {

        Patient patient = PatientMapper.toEntity(patientDTO);

        Patient savedPatient =
                patientRepository.save(patient);


        return PatientMapper.toDTO(savedPatient);
    }


    public void deletePatient(Long id) {

        Patient patient = patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with id: " + id
                        )
                );

        patientRepository.delete(patient);
    }

}