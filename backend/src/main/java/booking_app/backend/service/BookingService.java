package booking_app.backend.service;

import booking_app.backend.dto.BookingRequestDto;
import booking_app.backend.dto.BookingResponseDto;
import booking_app.backend.model.User;
import java.util.List;

public interface BookingService {
    BookingResponseDto createBooking(BookingRequestDto request, User user);

    List<BookingResponseDto> findBookingsByUserId(Long userId);

    BookingResponseDto findBookingById(Long id);

    BookingResponseDto confirmBooking(Long id);

    BookingResponseDto cancelBooking(Long id, User user);

    BookingResponseDto completeBooking(Long id);
}
