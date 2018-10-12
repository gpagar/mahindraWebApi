package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ganesh.mahindra.model.LearningLibrary;

public interface LearningLibraryRepository extends JpaRepository<LearningLibrary, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE LearningLibrary SET del_status=1  WHERE file_id=:fileId") 
	int deleteFile(@Param("fileId") int fileId);

	List<LearningLibrary> findByDelStatus(int i);

}
