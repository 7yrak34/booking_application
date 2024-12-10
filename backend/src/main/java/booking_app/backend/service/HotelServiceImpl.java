package booking_app.backend.service;

import booking_app.backend.dto.CreateHotelDto;
import booking_app.backend.dto.HotelDto;
import booking_app.backend.exception.EntityNotFoundException;
import booking_app.backend.mapper.HotelMapper;
import booking_app.backend.model.Hotel;
import booking_app.backend.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;


    @Override
    @Transactional
    public HotelDto saveHotel(CreateHotelDto hotelDto) {
        Hotel hotel = hotelMapper.toModel(hotelDto);
        Hotel savedHotel = hotelRepository.save(hotel);
        log.info("Hotel with id {} was created.", savedHotel.getId());
        return hotelMapper.toDto(savedHotel);
    }

    @Override
    public List<HotelDto> getAllHotels() {
        List<HotelDto> hotels = hotelRepository.findAll().stream()
                .map(hotelMapper::toDto)
                .toList();
        return hotels;
    }

    @Override
    public HotelDto getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find hotel by id: " + id));
        return hotelMapper.toDto(hotel);
    }

    @Override
    public List<byte[]> getHotelImages(Long id) {
        Hotel hotel = hotelRepository.findByIdWithImages(id).orElseThrow(
                () -> new EntityNotFoundException("Hotel not found with id: " + id));
        return hotel.getHotelImages();
    }

    @Override
    @Transactional
    public HotelDto updateHotel(Long id, CreateHotelDto updatedHotel) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There's not hotel with id: " + id));
        hotelMapper.updateHotel(updatedHotel, hotel);
        log.info("Hotel with id {} is updated.", id);
        return hotelMapper.toDto(hotelRepository.save(hotel));
    }

    @Override
    @Transactional
    public void addImageToHotel(Long id, MultipartFile image) throws IOException {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hotel with id " + id
                        + " not found"));
        if (image.isEmpty()) {
            throw new IllegalArgumentException("Hotel file cannot be empty");
        }
        String contentType = image.getContentType();
        if (!contentType.startsWith("image/")) {
            throw new IllegalArgumentException("File must be an image");
        }
        hotel.addImageToHotel(image.getBytes());
        hotelRepository.save(hotel);
    }

    @Override
    @Transactional
    public void deleteHotel(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("There's not hotel with id: " + id));
        hotelRepository.deleteById(id);
        log.info("Hotel with id {} was deleted.", id);
    }
}
