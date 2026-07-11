package com.hospital_management_system.service;

import com.hospital_management_system.entity.Token;
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


    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }


    public Optional<Token> getTokenById(Long id) {
        return tokenRepository.findById(id);
    }


    public Token saveToken(Token token) {
        return tokenRepository.save(token);
    }


    public void deleteToken(Long id) {
        tokenRepository.deleteById(id);
    }

}