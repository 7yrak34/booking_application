package booking_app.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateHotelDto {
    @NotBlank
    private String name;
    @NotBlank
    private String address;
    @NotBlank
    private String contactData;
    @NotBlank
    private String description;
}
