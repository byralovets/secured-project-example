package by.ralovets.students.facade;

import by.ralovets.students.dto.LoginRequestDto;
import by.ralovets.students.dto.RegisterRequestDto;
import by.ralovets.students.dto.TokenResponseDto;
import by.ralovets.students.service.AuthService;
import by.ralovets.students.service.JwtService;
import by.ralovets.students.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AuthFacade {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthService authService;

    @Transactional(readOnly = true)
    public TokenResponseDto login(LoginRequestDto dto) {
        authService.login(dto.getUsername(), dto.getPassword());

        return jwtService.generateToken(dto.getUsername());
    }

    @Transactional
    public TokenResponseDto register(RegisterRequestDto dto) {
        final String username = dto.getUsername();
        final String password = dto.getPassword();

        userService.createUser(username, password);
        authService.login(username, password); // exception

        return jwtService.generateToken(username); // error response 500 Internal Server Error
    }
}












// create user with id 0                    1

// save event "name changed to ___"         2

// save event "role changed to ADMIN"       3




















