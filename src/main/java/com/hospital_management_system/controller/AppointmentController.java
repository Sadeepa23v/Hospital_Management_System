package com.hospital_management_system.controller;

import com.hospital_management_system.dto.AppointmentDTO;
import com.hospital_management_system.service.AppointmentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@CrossOrigin
public class AppointmentController {

    private final AppointmentService appointmentService;


    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }


    @GetMapping
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }


    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id) {

        return appointmentService.getAppointmentById(id)
                .orElse(null);
    }


    @PostMapping
    public AppointmentDTO createAppointment(
            @Valid @RequestBody AppointmentDTO appointmentDTO) {

        return appointmentService.saveAppointment(appointmentDTO);
    }


    @DeleteMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {

        appointmentService.deleteAppointment(id);

        return "Appointment deleted successfully";
    }

}