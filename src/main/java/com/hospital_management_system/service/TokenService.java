package com.hospital_management_system.service;

import com.hospital_management_system.dto.TokenDTO;
import com.hospital_management_system.entity.Token;
import com.hospital_management_system.mapper.TokenMapper;
import com.hospital_management_system.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<TokenDTO> getTokenById(Long id) {

        return tokenRepository.findById(id)
                .map(TokenMapper::toDTO);
    }


    public TokenDTO saveToken(TokenDTO tokenDTO) {

        Token token = TokenMapper.toEntity(tokenDTO);

        Token savedToken = tokenRepository.save(token);

        return TokenMapper.toDTO(savedToken);
    }


    public void deleteToken(Long id) {

        tokenRepository.deleteById(id);
    }

}