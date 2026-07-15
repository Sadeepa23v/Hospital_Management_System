package com.hospital_management_system.service;

import com.hospital_management_system.dto.AppointmentDTO;
import com.hospital_management_system.entity.Appointment;
import com.hospital_management_system.exception.ResourceNotFoundException;
import com.hospital_management_system.mapper.AppointmentMapper;
import com.hospital_management_system.repository.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public AppointmentDTO getAppointmentById(Long id) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Appointment not found with id: " + id
                                )
                        );


        return AppointmentMapper.toDTO(appointment);
    }


    public AppointmentDTO saveAppointment(
            AppointmentDTO appointmentDTO) {


        Appointment appointment =
                AppointmentMapper.toEntity(appointmentDTO);


        Appointment savedAppointment =
                appointmentRepository.save(appointment);


        return AppointmentMapper.toDTO(savedAppointment);
    }


    public void deleteAppointment(Long id) {

        Appointment appointment =
                appointmentRepository.findById(id)
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Appointment not found with id: " + id
                                )
                        );


        appointmentRepository.delete(appointment);
    }

}