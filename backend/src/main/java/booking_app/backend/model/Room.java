package booking_app.backend.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@SQLDelete(sql = "UPDATE rooms SET is_deleted = true WHERE id = ?")
@SQLRestriction(value = "is_deleted = FALSE")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "room_number", nullable = false)
    private String roomNumber;

    @Column(name = "description", nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RoomType type;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable = true;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    @ToString.Exclude
    private byte[] image;

    public enum RoomType {
        SINGLE,
        DOUBLE,
        SUITE,
        DELUXE,
        FAMILY,
        STUDIO,
        PENTHOUSE,
        TWIN
    }
}

