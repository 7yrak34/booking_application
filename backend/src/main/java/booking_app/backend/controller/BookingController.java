package booking_app.backend.controller;

import booking_app.backend.dto.BookingRequestDto;
import booking_app.backend.dto.BookingResponseDto;
import booking_app.backend.model.User;
import booking_app.backend.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Booking management", description = "Endpoints for managing bookings ")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @Operation(summary = "Create a booking", description = "Create a new user booking.")
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto request,
                                            Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return bookingService.createBooking(request, user);
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    @Operation(summary = "Get bookings", description = "Get bookings by users ID")
    public List<BookingResponseDto> getBookingsByUser(
            @RequestParam(name = "user_id", required = false) @Positive Long userId,
            Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();

        if (currentUser.hasRoleAdmin()) {
                return bookingService.findBookingsByUserId(userId);
        } else {
            return bookingService.findBookingsByUserId(currentUser.getId());
        }
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    @Operation(summary = "Get a booking", description = "Get a booking by id")
    public BookingResponseDto getBookingById(@PathVariable @Positive Long id) {
        return bookingService.findBookingById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{id}/confirm")
    @Operation(summary = "Confirm a booking", description = "Set status of booking as confirmed")
    public BookingResponseDto confirmBooking(@PathVariable @Positive Long id) {
        return bookingService.confirmBooking(id);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/{id}/cancel")
    @Operation(summary = "Complete a booking", description = "Set status of booking as cancelled "
            + "(set room as available)")
    public BookingResponseDto cancelBooking(@PathVariable @Positive Long id,
                                            Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return bookingService.cancelBooking(id, user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/{id}/complete")
    @Operation(summary = "Complete a booking", description = "Set status of booking as completed "
            + "(set room as available)")
    public BookingResponseDto completeBooking(@PathVariable @Positive Long id) {
        return bookingService.completeBooking(id);
    }
}
