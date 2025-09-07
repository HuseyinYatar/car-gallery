package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.GalleristCar;

@Repository
public interface GalleristCarRepository  extends JpaRepository<GalleristCar,Long>{
}
