package booking_app.backend.service;

import booking_app.backend.dto.room.RoomDtoWithoutHotelIds;
import booking_app.backend.dto.room.RoomRequestDto;
import booking_app.backend.dto.room.RoomResponseDto;
import booking_app.backend.exception.EntityNotFoundException;
import booking_app.backend.mapper.RoomMapper;
import booking_app.backend.model.Room;
import booking_app.backend.repository.RoomRepository;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    @Override
    public RoomResponseDto createRoom(RoomRequestDto requestDto) {
        RoomResponseDto responseDto = roomMapper
                .toResponseDto(roomRepository
                        .save(roomMapper
                                .toEntity(requestDto)));
        return responseDto;
    }

    @Override
    public RoomResponseDto getRooById(Long id) {
        Room room = findRoomById(id);
        return roomMapper.toResponseDto(room);
    }

    @Override
    public List<RoomResponseDto> getAllRooms(Pageable pageable) {
        List<RoomResponseDto> responseDtoList = roomMapper.toResponseDtoList(roomMapper
                .toRoomModelsList(roomRepository
                        .findAll(pageable)));
        return responseDtoList;
    }

    @Override
    public List<RoomDtoWithoutHotelIds> getAllRoomsWithoutHotelIds(Long hotelId, Pageable pageable) {
        return roomMapper
                .toRoomsDtoWithoutHotelIds(roomRepository
                        .findAllByHotelId(hotelId, pageable));
    }

    @Override
    @Transactional
    public RoomResponseDto updateRoom(Long id, RoomRequestDto requestDto) {
        Room room = findRoomById(id);
        roomMapper.updateEntity(room, requestDto);
        roomRepository.save(room);
        RoomResponseDto responseDto = roomMapper.toResponseDto(room);
        return responseDto;
    }

    @Override
    @Transactional
    public void addRoomImage(Long roomId, MultipartFile imageFile) {
        Room room = findRoomById(roomId);
        if(imageFile.isEmpty()) {
            throw new IllegalStateException("Image can't be empty");
        }
        String contentType = imageFile.getContentType();
        if (!contentType.startsWith("image/")) {
            throw new IllegalArgumentException("File must be an image: " + imageFile.getName());
        }
        try {
            room.addImageToRoom(imageFile.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't add image to room: " + roomId + e);
        }
        roomRepository.save(room);
    }

    @Override
    @Transactional
    public void removeRoomImage(Long roomId, int imageIndex) {
        Room room = findRoomById(roomId);

        if (imageIndex < 0 || imageIndex >= room.getRoomsImages().size()) {
            throw new IndexOutOfBoundsException("Invalid image index: " + imageIndex);
        }
        room.getRoomsImages().remove(imageIndex);
        roomRepository.save(room);
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }

    private Room findRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find room by id: " + id)
        );
    }
}
