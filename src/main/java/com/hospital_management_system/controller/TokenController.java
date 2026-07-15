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

        // TokenService#getTokenById returns a TokenDTO (not Optional),
        // so return it directly. If the service may return null, the
        // controller will return null (HTTP 200 with empty body).
        // For better API semantics consider returning ResponseEntity and
        // map null to 404, but keep this change minimal to fix the compile error.
        return tokenService.getTokenById(id);
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