package booking_app.backend.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequestDto {
    @NotNull
    private Long roomId;
    @NotNull
    private LocalDate checkInDate;
    @NotNull
    private LocalDate checkOutDate;
}
