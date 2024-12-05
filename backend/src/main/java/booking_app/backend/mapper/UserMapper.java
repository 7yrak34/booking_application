package booking_app.backend.mapper;

import booking_app.backend.config.MapperConfig;
import booking_app.backend.dto.UserDto;
import booking_app.backend.dto.UserRegistrationRequestDto;
import booking_app.backend.dto.UserResponseDto;
import booking_app.backend.model.User;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserResponseDto toDto(User user);

    User toModel(UserRegistrationRequestDto registrationRequestDto);

    UserDto toUserDto(User user);
}
