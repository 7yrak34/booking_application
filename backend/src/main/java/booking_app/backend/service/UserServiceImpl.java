package booking_app.backend.service;

import booking_app.backend.dto.UpdateUserProfileRequestDto;
import booking_app.backend.dto.UserDto;
import booking_app.backend.dto.UserRegistrationRequestDto;
import booking_app.backend.dto.UserResponseDto;
import booking_app.backend.exception.EntityNotFoundException;
import booking_app.backend.exception.RegistrationException;
import booking_app.backend.mapper.UserMapper;
import booking_app.backend.model.User;
import booking_app.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponseDto register(UserRegistrationRequestDto registrationRequestDto)
            throws RegistrationException {
        if (userRepository.existsByEmail(registrationRequestDto.getEmail())) {
            throw new RegistrationException("User with email " + registrationRequestDto.getEmail()
                    + " already exists");
        }
        User user = userMapper.toModel(registrationRequestDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(User.UserRole.ROLE_USER);
        log.info("New users was registered with id {}", user.getId());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDto getCurrentUserProfile(User user) {
        return userMapper.toUserDto(user);
    }

    @Override
    @Transactional
    public UserDto updateUserProfile(UpdateUserProfileRequestDto userProfileRequestDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setFirstName(userProfileRequestDto.getFirstName());
        user.setLastName(userProfileRequestDto.getLastName());
        user.setEmail(userProfileRequestDto.getEmail());
        log.info("User's profile with id {} was changed", user.getId());
        return userMapper.toUserDto(userRepository.save(user));
    }
}
