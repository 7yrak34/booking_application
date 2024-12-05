package booking_app.backend.service;


import booking_app.backend.dto.*;
import booking_app.backend.exception.RegistrationException;
import booking_app.backend.model.User;

public interface UserService {
    UserResponseDto register(UserRegistrationRequestDto registrationRequestDto)
            throws RegistrationException;

    UserDto getCurrentUserProfile(User user);

    UserDto updateUserProfile(UpdateUserProfileRequestDto userProfileRequestDto, Long id);

    PasswordResponse changeUserPassword(ChangeUserPasswordRequestDto roleRequestDto, Long id);

    CardResponse addBankCardToUser(String bankCard, Long id);
}
