package booking_app.backend.service;

import booking_app.backend.dto.room.RoomDtoWithoutHotelIds;
import booking_app.backend.dto.room.RoomRequestDto;
import booking_app.backend.dto.room.RoomResponseDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface RoomService {

    RoomResponseDto createRoom(RoomRequestDto requestDto);

   RoomResponseDto getRooById(Long id);

    List<RoomResponseDto> getAllRooms(Pageable pageable);

    List<RoomDtoWithoutHotelIds> getAllRoomsWithoutHotelIds(Long hotelId, Pageable pageable);

    RoomResponseDto updateRoom(Long id, RoomRequestDto requestDto);

    void delete(Long id);
}
