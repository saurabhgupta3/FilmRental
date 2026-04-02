package com.filmrental.FilmRental.controller;


import com.filmrental.FilmRental.constants.AuthConstant;
import com.filmrental.FilmRental.dto.ApiResponseDTO;
import com.filmrental.FilmRental.dto.LoginRequestDTO;
import com.filmrental.FilmRental.dto.LoginResponseDTO;
import com.filmrental.FilmRental.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponseDTO> login(@RequestBody LoginRequestDTO request) {

        log.info("Received login request for username: {}", request.getUsername());

        LoginResponseDTO response = authService.login(request);

        ResponseCookie responseCookie = ResponseCookie.from("token", response.getToken())
                .path("/api/v1")
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(new ApiResponseDTO(
                        "200",
                        "Login successful",
                        response
                ));
    }

    @GetMapping ("/logout")
    public ResponseEntity<ApiResponseDTO> logout() {
        ResponseCookie responseCookie = ResponseCookie.from("token", "")
                .path("/api/v1")
                .maxAge(0)
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .build();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(new ApiResponseDTO(
                        "200",
                        "Logout successful",
                        null
                ));
    }
}