package booking_app.backend.dto.room;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class RoomRequestDto {
    @Positive
    private Long hotelId;
    @Positive
    private int capacity;
    @NotBlank
    private String roomNumber;
    @NotBlank
    @Length(min = 20, max = 500)
    private String description;
    @NotBlank
    private String type;
    @Positive
    private BigDecimal price;
    @NotNull
    private boolean isAvailable;
}
