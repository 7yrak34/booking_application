package booking_app.backend.mapper;

import booking_app.backend.config.MapperConfig;
import booking_app.backend.dto.*;
import booking_app.backend.model.Hotel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface HotelMapper {
    HotelDto toDto(Hotel hotel);

    Hotel toModel(CreateHotelDto registrationRequestDto);

    void updateHotel(CreateHotelDto updatedHotel, @MappingTarget Hotel hotel);
}
