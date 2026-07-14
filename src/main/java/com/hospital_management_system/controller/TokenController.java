package com.hospital_management_system.controller;

import com.hospital_management_system.dto.TokenDTO;
import com.hospital_management_system.service.TokenService;
import jakarta.validation.Valid;
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
    public List<TokenDTO> getAllTokens() {
        return tokenService.getAllTokens();
    }


    @GetMapping("/{id}")
    public TokenDTO getTokenById(@PathVariable Long id) {

        return tokenService.getTokenById(id)
                .orElse(null);
    }


    @PostMapping
    public TokenDTO createToken(
            @Valid @RequestBody TokenDTO tokenDTO) {

        return tokenService.saveToken(tokenDTO);
    }


    @DeleteMapping("/{id}")
    public String deleteToken(@PathVariable Long id) {

        tokenService.deleteToken(id);

        return "Token deleted successfully";
    }

}