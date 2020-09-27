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

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private String id;

    @Column(name = "user", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(50)", length = 50)
    private String password;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createdAt;

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @PrePersist
    private void prePersist() {
        createdAt = new Date();
    }
}
