package co.jdti.practice.travelagency.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Table(name = "hotels")
@Entity
@Data
@NoArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", length = 50)
    private String id;

    @Column(name = "user", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "city", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String city;

    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String type;

    @Column(name = "guests_quantity", nullable = false, columnDefinition = "INTEGER(3)", length = 3)
    private Integer guestsQuantity;

    @Column(name = "rooms_quantity", nullable = false, columnDefinition = "INTEGER(3)", length = 3)
    private Integer roomsQuantity;

    @Column(name = "baths_quantity", nullable = false, columnDefinition = "INTEGER(3)", length = 3)
    private Integer bathsQuantity;

    @Column(name = "beds_quantity", nullable = false, columnDefinition = "INTEGER(3)", length = 3)
    private Integer bedsQuantity;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public HotelEntity(String name, String city, String type, Integer guestsQuantity, Integer roomsQuantity, Integer bathsQuantity, Integer bedsQuantity) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.guestsQuantity = guestsQuantity;
        this.roomsQuantity = roomsQuantity;
        this.bathsQuantity = bathsQuantity;
        this.bedsQuantity = bedsQuantity;
    }

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
    }

}
