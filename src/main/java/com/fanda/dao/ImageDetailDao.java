package main.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import main.Entity.Picture;

public interface ImageDetailDao extends JpaRepository<Picture, Integer> {
	@Query("select p from Picture p where p.product.id = ?1")
	List<Picture> findPictureWhereId(Integer id);
	
	
}
