package com.hospital_management_system.controller;

import com.hospital_management_system.dto.DoctorDTO;
import com.hospital_management_system.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@CrossOrigin
public class DoctorController {

    private final DoctorService doctorService;


    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }


    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorService.getAllDoctors();
    }


    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id) {

        return doctorService.getDoctorById(id)
                .orElse(null);
    }


    @PostMapping
    public DoctorDTO createDoctor(
            @Valid @RequestBody DoctorDTO doctorDTO) {

        return doctorService.saveDoctor(doctorDTO);
    }


    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return "Doctor deleted successfully";
    }

}