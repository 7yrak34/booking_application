package booking_app.backend.dto.room;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class RoomDtoWithoutHotelIds {
    private Long id;
    private int capacity;
    private String roomNumber;
    private String description;
    private String type;
    private BigDecimal price;
    private boolean isAvailable;
}
