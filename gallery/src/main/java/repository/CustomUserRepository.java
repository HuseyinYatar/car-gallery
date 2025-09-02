package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import entity.CustomUser;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser , Long>{
	
	
	@Query("from CustomUser c where c.username=?1")
	Optional<CustomUser> findByUserName(String username);
}
