package booking_app.backend.controller;

import booking_app.backend.dto.UpdateUserProfileRequestDto;
import booking_app.backend.dto.UserDto;
import booking_app.backend.model.User;
import booking_app.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User management", description = "Endpoints for managing users "
        + "authentication and profiles")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/me")
    @Operation(summary = "Get my profile info", description = "Retrieve profile information of "
            + "the authenticated users")
    public UserDto getMyProfile(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userService.getCurrentUserProfile(user);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/me")
    @Operation(summary = "Update profile info", description = "Update profile information of "
            + "the authenticated users")
    public UserDto updateProfileInfo(
            @RequestBody @Valid UpdateUserProfileRequestDto userProfileRequestDto,
            Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return userService.updateUserProfile(userProfileRequestDto, user.getId());
    }
}
