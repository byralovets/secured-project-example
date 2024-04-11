package by.ralovets.students.controller;

import by.ralovets.students.dto.LoginRequestDto;
import by.ralovets.students.dto.RegisterRequestDto;
import by.ralovets.students.dto.TokenResponseDto;
import by.ralovets.students.facade.AuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthFacade authFacade;

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto dto) {
        return authFacade.login(dto);
    }

    @PostMapping("/registration")
    public TokenResponseDto register(@RequestBody RegisterRequestDto dto) {
        return authFacade.register(dto);
    }
}
