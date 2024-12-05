package booking_app.backend.service;


import booking_app.backend.dto.UpdateUserProfileRequestDto;
import booking_app.backend.dto.UserDto;
import booking_app.backend.dto.UserRegistrationRequestDto;
import booking_app.backend.dto.UserResponseDto;
import booking_app.backend.exception.RegistrationException;
import booking_app.backend.model.User;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto registrationRequestDto)
            throws RegistrationException;

    UserDto getCurrentUserProfile(User user);

    UserDto updateUserProfile(UpdateUserProfileRequestDto userProfileRequestDto, Long id);
}
