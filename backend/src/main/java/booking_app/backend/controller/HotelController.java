package booking_app.backend.controller;

import booking_app.backend.dto.CreateHotelDto;
import booking_app.backend.dto.HotelDto;
import booking_app.backend.service.HotelService;
import booking_app.backend.service.ImageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

@Tag(name = "Hotel management", description = "Endpoints for managing hotels ")
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Create a hotel", description = "Create a hotel and add it to the DB.")
    public HotelDto createHotel(@RequestBody CreateHotelDto hotel) {
        HotelDto savedHotel = hotelService.saveHotel(hotel);
        return savedHotel;
    }

    @GetMapping
    @Operation(summary = "Get all hotels", description = "Pull all hotels from the DB.")
    public List<HotelDto> getAllHotels() {
        List<HotelDto> hotels = hotelService.getAllHotels();
        return hotels;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get hotel by id", description = "Retrieve a hotel by it's id.")
    public HotelDto getHotelById(@PathVariable Long id) {
        HotelDto hotel = hotelService.getHotelById(id);
        return hotel;
    }

    @PreAuthorize("permitAll()")
    @Operation(summary = "Get hotel images", description = "Retrieve hotel images by it's id.")
    @GetMapping("/{id}/images")
    public ResponseEntity<List<String>> getHotelImages(@PathVariable Long id) {
        List<byte[]> images = hotelService.getHotelImages(id);
        List<String> base64Images = ImageUtils.convertToBase64(images);
        return ResponseEntity.ok(base64Images);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Update a hotel", description = "Update an information of hotel"
            + "and save updates in the DB.")
    public HotelDto updateHotel(@PathVariable Long id, @RequestBody CreateHotelDto updatedHotel) {
        HotelDto hotel = hotelService.updateHotel(id, updatedHotel);
        return hotel;
    }

    @PostMapping("/{id}/images")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Add image to a hotel", description = "Add an hotel image"
            + "and update information in the DB.")
    public ResponseEntity<String> addImageToHotel(@PathVariable Long id,
                                                  @RequestParam("image") MultipartFile image)
            throws IOException {
        hotelService.addImageToHotel(id, image);
        return ResponseEntity.ok("Image added successfully");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Delete a hotel", description = "Delete a hotel by it's id.")
    public ResponseEntity<String> deleteHotel(@PathVariable Long id) {
        hotelService.deleteHotel(id);
        return ResponseEntity.ok("Hotel deleted successfully");
    }
}
