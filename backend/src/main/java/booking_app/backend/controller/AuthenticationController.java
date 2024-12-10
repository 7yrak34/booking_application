package booking_app.backend.controller;

import booking_app.backend.dto.user.login.UserLoginRequestDto;
import booking_app.backend.dto.user.login.UserLoginResponseDto;
import booking_app.backend.dto.user.login.UserRegistrationRequestDto;
import booking_app.backend.dto.user.UserResponseDto;
import booking_app.backend.exception.RegistrationException;
import booking_app.backend.security.AuthenticationService;
import booking_app.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Endpoints for authentication users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/registration")
    @Operation(summary = "Register a new users",
            description = "Create a new users and save it in DB")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto registerUser(@RequestBody @Valid UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Authenticates an users and returns JWT token")
    public UserLoginResponseDto login(@RequestBody @Valid UserLoginRequestDto request) {
        return authenticationService.authenticate(request);
    }
}
