package com.hospital_management_system.mapper;

import com.hospital_management_system.dto.TokenDTO;
import com.hospital_management_system.entity.Token;

public class TokenMapper {


    // Entity -> DTO
    public static TokenDTO toDTO(Token token) {

        if (token == null) {
            return null;
        }


        TokenDTO dto = new TokenDTO();


        Integer tokenId = token.getTokenId();

        dto.setTokenId(
                tokenId == null ? null : tokenId.longValue()
        );


        dto.setTokenNumber(
                token.getTokenNumber()
        );


        dto.setStatus(
                token.getStatus()
        );


        if(token.getAppointment() != null){

            dto.setAppointmentId(
                    token.getAppointment()
                            .getAppointmentId()
                            .longValue()
            );
        }


        return dto;
    }



    // DTO -> Entity
    public static Token toEntity(TokenDTO dto) {

        if(dto == null){
            return null;
        }


        Token token = new Token();


        Long tokenId = dto.getTokenId();

        token.setTokenId(
                tokenId == null ? null : tokenId.intValue()
        );


        token.setTokenNumber(
                dto.getTokenNumber()
        );


        token.setStatus(
                dto.getStatus()
        );


        return token;
    }
}