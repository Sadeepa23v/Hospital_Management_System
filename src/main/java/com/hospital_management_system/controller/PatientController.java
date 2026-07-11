package com.hospital_management_system.controller;

import com.hospital_management_system.entity.Patient;
import com.hospital_management_system.service.PatientService;
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
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }


    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id)
                .orElse(null);
    }


    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }


    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }

}