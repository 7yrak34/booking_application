package booking_app.backend.repository;

import booking_app.backend.model.Hotel;
import booking_app.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface HotelRepositoy extends JpaRepository<Hotel, Long> {

}