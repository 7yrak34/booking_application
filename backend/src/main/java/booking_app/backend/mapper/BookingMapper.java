package booking_app.backend.mapper;

import booking_app.backend.config.MapperConfig;
import booking_app.backend.dto.BookingRequestDto;
import booking_app.backend.dto.BookingResponseDto;
import booking_app.backend.model.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface BookingMapper {
    Booking toModel(BookingRequestDto bookingRequestDto);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "roomId", source = "room.id")
    BookingResponseDto toDto(Booking booking);
}
