package booking_app.backend.dto;

import booking_app.backend.model.Hotel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.util.List;

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
    @NotEmpty(message = "Amenities cannot be empty")
    private List<Hotel.Amenity> amenities;
}
