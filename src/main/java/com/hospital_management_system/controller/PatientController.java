package com.hospital_management_system.controller;

import com.hospital_management_system.dto.PatientDTO;
import com.hospital_management_system.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }


    @GetMapping
    public List<PatientDTO> getAllPatients() {
        return patientService.getAllPatients();
    }


    @GetMapping("/{id}")
    public PatientDTO getPatientById(@PathVariable Long id) {

        return patientService.getPatientById(id)
                .orElse(null);
    }


    @PostMapping
    public PatientDTO createPatient(
            @Valid @RequestBody PatientDTO patientDTO) {

        return patientService.savePatient(patientDTO);
    }


    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {

        patientService.deletePatient(id);

        return "Patient deleted successfully";
    }

}