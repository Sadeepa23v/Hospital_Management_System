package com.hospital_management_system.service;

import com.hospital_management_system.dto.AppointmentDTO;
import com.hospital_management_system.entity.Appointment;
import com.hospital_management_system.mapper.AppointmentMapper;
import com.hospital_management_system.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public List<AppointmentDTO> getAllAppointments() {

        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toDTO)
                .toList();
    }


    public Optional<AppointmentDTO> getAppointmentById(Long id) {

        return appointmentRepository.findById(id)
                .map(AppointmentMapper::toDTO);
    }


    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {

        Appointment appointment = AppointmentMapper.toEntity(appointmentDTO);

        Appointment savedAppointment = appointmentRepository.save(appointment);

        return AppointmentMapper.toDTO(savedAppointment);
    }


    public void deleteAppointment(Long id) {

        appointmentRepository.deleteById(id);
    }

}