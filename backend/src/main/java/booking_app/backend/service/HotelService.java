package booking_app.backend.service;

import booking_app.backend.dto.CreateHotelDto;
import booking_app.backend.dto.HotelDto;
import booking_app.backend.model.Hotel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HotelService {
    HotelDto saveHotel(CreateHotelDto hotelDto);

    List<HotelDto> getAllHotels();

    HotelDto getHotelById(Long id);

    List<byte[]> getHotelImages(Long id);

    HotelDto updateHotel(Long id, CreateHotelDto updatedHotel);

    void addImageToHotel(Long id, MultipartFile image) throws IOException;

    void deleteHotel(Long id);
}
