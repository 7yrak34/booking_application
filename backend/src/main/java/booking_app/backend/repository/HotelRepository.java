package booking_app.backend.repository;

import booking_app.backend.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @Query("SELECT h FROM Hotel h left JOIN FETCH h.hotelImages WHERE h.id = :id")
    Optional<Hotel> findByIdWithImages(@Param("id") Long id);

}
