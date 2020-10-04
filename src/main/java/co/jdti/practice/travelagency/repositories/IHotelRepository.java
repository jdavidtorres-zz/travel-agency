package co.jdti.practice.travelagency.repositories;

import co.jdti.practice.travelagency.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHotelRepository extends JpaRepository<HotelEntity, String> {

}
