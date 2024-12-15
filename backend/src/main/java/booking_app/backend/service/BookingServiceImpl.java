package booking_app.backend.service;

import booking_app.backend.dto.BookingRequestDto;
import booking_app.backend.dto.BookingResponseDto;
import booking_app.backend.exception.BookingException;
import booking_app.backend.exception.EntityNotFoundException;
import booking_app.backend.mapper.BookingMapper;
import booking_app.backend.model.Booking;
import booking_app.backend.model.Room;
import booking_app.backend.model.User;
import booking_app.backend.repository.booking.BookingRepository;
import booking_app.backend.repository.RoomRepository;
import booking_app.backend.repository.booking.BookingSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final BookingMapper bookingMapper;

    @Override
    @Transactional
    public BookingResponseDto createBooking(BookingRequestDto request, User user) {
        Room room = roomRepository.findById(request.getRoomId()).orElseThrow(
                () -> new EntityNotFoundException("Can't find room by id: " + request.getRoomId()));
        if (!room.isAvailable()) {
            throw new BookingException("Room is not available for booking.");
        }

        Booking booking = bookingMapper.toModel(request);
        booking.setUser(user);
        booking.setRoom(room);
        booking.setTotalPrice(room.getPrice());
        room.setAvailable(false);
        roomRepository.save(room);
        Booking savedBooking = bookingRepository.save(booking);
        log.info("Booking with id {} was created", savedBooking.getId());
        return bookingMapper.toDto(savedBooking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BookingResponseDto> findBookingsByUserId(Long userId) {
        Specification<Booking> spec = BookingSpecification.byUser(userId);
        return bookingRepository.findAll(spec).stream()
                .map(bookingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public BookingResponseDto findBookingById(Long id) {
        return bookingMapper.toDto(bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + id)));
    }

    @Override
    @Transactional
    public BookingResponseDto confirmBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + id));
        if (!booking.getStatus().equals(Booking.BookingStatus.PENDING)) {
            throw new BookingException("Booking is already " + booking.getStatus());
        }
        booking.setStatus(Booking.BookingStatus.CONFIRMED);
        Booking updatedBooking = bookingRepository.save(booking);
        log.info("Booking with id {} is confirmed", id);
        return bookingMapper.toDto(updatedBooking);
    }

    @Override
    @Transactional
    public BookingResponseDto cancelBooking(Long id, User user) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + id));
        if (!user.hasRoleAdmin() && !Objects.equals(user.getId(), booking.getUser().getId())) {
            throw new BookingException("Only owner of booking or admin "
                    + "can cancel his booking");
        }
        switch (booking.getStatus()) {
            case COMPLETED -> throw new BookingException("Booking is already completed");
            case CANCELLED -> throw new BookingException("Booking is already cancelled");
        }
        Room room = booking.getRoom();
        booking.setStatus(Booking.BookingStatus.CANCELLED);
        room.setAvailable(true);
        roomRepository.save(room);
        Booking updatedBooking = bookingRepository.save(booking);
        log.info("Booking with id {} is cancelled, room with id {} is available",
                id, room.getId());
        return bookingMapper.toDto(updatedBooking);
    }

    @Override
    @Transactional
    public BookingResponseDto completeBooking(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Booking not found with ID: " + id));
        switch (booking.getStatus()) {
            case COMPLETED -> throw new BookingException("Booking is already completed");
            case CANCELLED -> throw new BookingException("Booking is already cancelled");
        }
        Room room = booking.getRoom();
        booking.setStatus(Booking.BookingStatus.COMPLETED);
        room.setAvailable(true);
        roomRepository.save(room);
        Booking updatedBooking = bookingRepository.save(booking);
        log.info("Booking with id {} is completed, room with id {} is available",
                id, room.getId());
        return bookingMapper.toDto(updatedBooking);
    }
}
