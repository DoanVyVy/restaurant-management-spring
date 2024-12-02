package org.example.restaurantmanager.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@jakarta.persistence.Table(name = "tables", schema = "restaurant_management", uniqueConstraints = {
        @UniqueConstraint(name = "table_number", columnNames = {"table_number"})
})
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "table_number", nullable = false)
    private Integer tableNumber;

    @ColumnDefault("'Available'")
    @Lob
    @Column(name = "status")
    private String status;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at")
    private Instant createdAt;

}