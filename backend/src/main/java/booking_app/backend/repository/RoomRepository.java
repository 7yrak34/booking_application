package booking_app.backend.repository;

import booking_app.backend.model.Room;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    @EntityGraph(attributePaths = "hotel")
    List<Room> findAllByHotelId(Long hotelId, Pageable pageable);
}
