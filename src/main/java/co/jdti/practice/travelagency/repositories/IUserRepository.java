package co.jdti.practice.travelagency.repositories;

import co.jdti.practice.travelagency.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsername(String username);
}
