package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.SoldCar;

@Repository
public interface SoldRepository extends JpaRepository<SoldCar,Long> {

}
