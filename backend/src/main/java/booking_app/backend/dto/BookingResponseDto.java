package booking_app.backend.dto;

import booking_app.backend.model.Booking;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class BookingResponseDto {
    private Long id;
    private Long roomId;
    private Long userId;
    private LocalDateTime dateOfCreated;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal totalPrice;
    private Booking.BookingStatus status;
}