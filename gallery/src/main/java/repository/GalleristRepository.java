package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Gallerist;

@Repository
public interface GalleristRepository extends JpaRepository<Gallerist, Long>{
}
