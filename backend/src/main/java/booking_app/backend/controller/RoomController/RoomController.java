package booking_app.backend.controller.RoomController;

import booking_app.backend.dto.room.RoomRequestDto;
import booking_app.backend.dto.room.RoomResponseDto;
import booking_app.backend.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Rooms", description = "Rooms endpoints")
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    @Operation(summary = "Find all rooms",
            description = "Find all rooms with pagination and sorting")
    public List<RoomResponseDto> getAllRooms(Pageable pageable) {
        return roomService.getAllRooms(pageable);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find a room by ID",
            description = "Retrieve room details by its ID")
    public RoomResponseDto getRoomById(@PathVariable Long id) {
        return roomService.getRooById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @Operation(summary = "Create a new room",
            description = "Add a new room with the provided details")
    public RoomResponseDto createRoom(@RequestBody @Valid RoomRequestDto requestDto) {
        return roomService.createRoom(requestDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @Operation(summary = "Update room details",
            description = "Update the details of an existing room by ID")
    public RoomResponseDto updateRoom(
            @PathVariable Long id, @RequestBody @Valid RoomRequestDto requestDto) {
        return roomService.updateRoom(id, requestDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    @Operation(summary = "Delete a room",
            description = "Soft delete a room by marking it as deleted")
    public void deleteRoom(@PathVariable Long id) {
        roomService.delete(id);
    }
}
