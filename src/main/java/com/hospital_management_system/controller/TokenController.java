package com.hospital_management_system.controller;

import com.hospital_management_system.entity.Token;
import com.hospital_management_system.service.TokenService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }


    @GetMapping
    public List<Token> getAllTokens() {
        return tokenService.getAllTokens();
    }


    @PostMapping
    public Token createToken(@RequestBody Token token) {
        return tokenService.saveToken(token);
    }


    @DeleteMapping("/{id}")
    public String deleteToken(@PathVariable Long id) {
        tokenService.deleteToken(id);
        return "Token deleted successfully";
    }

}