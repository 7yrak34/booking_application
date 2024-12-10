package booking_app.backend.dto.user;

import booking_app.backend.model.User;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private User.UserRole role;
}

