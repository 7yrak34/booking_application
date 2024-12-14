package booking_app.backend.dto;

import booking_app.backend.model.Hotel;
import lombok.Data;

import java.util.List;

@Data
public class HotelDto {
    private Long id;
    private String name;
    private String address;
    private String contactData;
    private String description;
    private List<Hotel.Amenity> amenities;
}
