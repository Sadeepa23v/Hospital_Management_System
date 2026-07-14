package com.hospital_management_system.dto;

import java.time.LocalDate;

public class TokenDTO {

    private Long tokenId;
    private Long appointmentId;
    private Integer tokenNumber;
    private LocalDate tokenDate;
    private String status;

    public TokenDTO() {
    }

    public TokenDTO(Long tokenId, Long appointmentId,
                    Integer tokenNumber,
                    LocalDate tokenDate,
                    String status) {

        this.tokenId = tokenId;
        this.appointmentId = appointmentId;
        this.tokenNumber = tokenNumber;
        this.tokenDate = tokenDate;
        this.status = status;
    }

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Integer getTokenNumber() {
        return tokenNumber;
    }

    public void setTokenNumber(Integer tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public LocalDate getTokenDate() {
        return tokenDate;
    }

    public void setTokenDate(LocalDate tokenDate) {
        this.tokenDate = tokenDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}