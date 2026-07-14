package com.hospital_management_system.mapper;

import com.hospital_management_system.dto.AppointmentDTO;
import com.hospital_management_system.entity.Appointment;

public class AppointmentMapper {


    // Entity -> DTO
    public static AppointmentDTO toDTO(Appointment appointment) {

        if (appointment == null) {
            return null;
        }

        AppointmentDTO dto = new AppointmentDTO();


        Integer appointmentId = appointment.getAppointmentId();

        dto.setAppointmentId(
                appointmentId == null ? null : appointmentId.longValue()
        );


        if (appointment.getPatient() != null) {

            dto.setPatientId(
                    appointment.getPatient()
                            .getPatientId()
                            .longValue()
            );
        }


        if (appointment.getDoctor() != null) {

            dto.setDoctorId(
                    appointment.getDoctor()
                            .getDoctorId()
                            .longValue()
            );
        }


        dto.setAppointmentDate(
                appointment.getAppointmentDate()
        );

        dto.setStatus(
                appointment.getStatus()
        );


        return dto;
    }



    // DTO -> Entity
    public static Appointment toEntity(AppointmentDTO dto) {

        if (dto == null) {
            return null;
        }

        Appointment appointment = new Appointment();


        Long appointmentId = dto.getAppointmentId();

        appointment.setAppointmentId(
                appointmentId == null ? null : appointmentId.intValue()
        );


        appointment.setAppointmentDate(
                dto.getAppointmentDate()
        );

        appointment.setStatus(
                dto.getStatus()
        );


        return appointment;
    }
}