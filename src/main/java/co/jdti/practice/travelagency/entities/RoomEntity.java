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

@Table(name = "rooms")
@Entity
@Data
@NoArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)", length = 50)
    private String id;

    @Column(name = "user", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
    }
}
