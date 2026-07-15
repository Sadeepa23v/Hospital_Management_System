package com.hospital_management_system.service;

import com.hospital_management_system.dto.TokenDTO;
import com.hospital_management_system.entity.Token;
import com.hospital_management_system.exception.ResourceNotFoundException;
import com.hospital_management_system.mapper.TokenMapper;
import com.hospital_management_system.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {


    private final TokenRepository tokenRepository;


    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }


    public List<TokenDTO> getAllTokens() {

        return tokenRepository.findAll()
                .stream()
                .map(TokenMapper::toDTO)
                .toList();
    }


    public TokenDTO getTokenById(Long id) {

        Token token = tokenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Token not found with id: " + id
                        )
                );


        return TokenMapper.toDTO(token);
    }


    public TokenDTO saveToken(TokenDTO tokenDTO) {

        Token token =
                TokenMapper.toEntity(tokenDTO);


        Token savedToken =
                tokenRepository.save(token);


        return TokenMapper.toDTO(savedToken);
    }


    public void deleteToken(Long id) {

        Token token = tokenRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Token not found with id: " + id
                        )
                );


        tokenRepository.delete(token);
    }

}