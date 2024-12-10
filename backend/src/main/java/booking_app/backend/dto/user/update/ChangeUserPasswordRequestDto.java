package booking_app.backend.dto.user.update;

import booking_app.backend.validation.FieldMatch;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@FieldMatch(firstField = "oldPassword", secondField = "repeatedOldPassword")
public class ChangeUserPasswordRequestDto {
    @NotBlank
    private String oldPassword;
    @NotBlank
    private String repeatedOldPassword;
    @NotBlank
    private String newPassword;
}
