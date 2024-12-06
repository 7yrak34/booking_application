package booking_app.backend.controller;

import booking_app.backend.dto.*;
import booking_app.backend.model.User;
import booking_app.backend.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/me/password")
    @Operation(summary = "Change users' password", description = "Change the password"
            + " of users")
    public ResponseEntity<PasswordResponse> changeUserPassword(
            @RequestBody @Valid ChangeUserPasswordRequestDto changeUserPasswordRequestDto,
            Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        PasswordResponse response = userService.changeUserPassword(changeUserPasswordRequestDto,
                user.getId());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/me/bank-cards")
    @Operation(summary = "Add or update bank cards", description = "Add or update bank cards "
            + "to the user's profile")
    public ResponseEntity<CardResponse> addBankCards(
            @RequestBody String bankCard,
            Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        CardResponse updatedUserDto = userService.addBankCardToUser(bankCard, user.getId());
        return ResponseEntity.ok(updatedUserDto);
    }

    @PreAuthorize("isAuthenticated()")
    @PatchMapping("/me/photo")
    @Operation(summary = "Change profile photo", description = "Change the profile photo of "
            + "the authenticated user")
    public ResponseEntity<ImageResponse> changeUserPhoto(
            @RequestParam("image") MultipartFile image,
            Authentication authentication) throws IOException {
        User user = (User) authentication.getPrincipal();
        ImageResponse responseMessage = userService.changeUserPhoto(image, user.getId());
        return ResponseEntity.ok(responseMessage);
    }
}
