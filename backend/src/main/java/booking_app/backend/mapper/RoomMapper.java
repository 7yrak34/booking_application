package booking_app.backend.mapper;

import booking_app.backend.config.MapperConfig;
import booking_app.backend.dto.room.RoomDtoWithoutHotelIds;
import booking_app.backend.dto.room.RoomRequestDto;
import booking_app.backend.dto.room.RoomResponseDto;
import booking_app.backend.model.Room;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.data.domain.Page;

@Mapper(config = MapperConfig.class)
public interface RoomMapper {

    RoomResponseDto toResponseDto(Room room);

    @Mapping(source = "hotelId", target = "hotel.id")
    @Mapping(target = "id", ignore = true)
    Room toEntity(RoomRequestDto requestDto);

    List<RoomResponseDto> toResponseDtoList(List<Room> rooms);

    @Mapping(source = "hotelId", target = "hotel.id")
    @Mapping(target = "id", ignore = true)
    List<Room> toRoomModelsList(Page<Room> roomRequestDtos);

    @Mapping(target = "type", expression = "java(room.getType().name())")
    List<RoomDtoWithoutHotelIds> toRoomsDtoWithoutHotelIds(List<Room> rooms);

    @Mapping(target = "type", expression = "java(room.getType().name())")
    RoomDtoWithoutHotelIds toRoomDtoWithoutHotelIds(Room room);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "hotelId", target = "hotel.id")
    Room updateEntity(@MappingTarget Room room, RoomRequestDto requestDto);
}
