package booking_app.backend.dto;

import lombok.Data;

@Data
public class CreateHotelDto {
    private String name;
    private String address;
    private String contactData;
    private String description;
}
