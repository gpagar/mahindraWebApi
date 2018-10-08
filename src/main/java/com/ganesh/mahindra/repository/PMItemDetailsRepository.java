package com.ganesh.mahindra.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ganesh.mahindra.model.PMItemDetails;

public interface PMItemDetailsRepository extends JpaRepository<PMItemDetails, Integer>{

	
	List<PMItemDetails> findByActivityIdAndDelStatus(int activityId, int delStstaus);

	List<PMItemDetails> findByDelStatus(int i);


	@Modifying
	@Transactional
	@Query("update PMItemDetails m set m.delStatus=1  WHERE m.itemId=:itemId")
	int deleteItemId(@Param("itemId")int itemId );

	PMItemDetails findByItemId(int itemId);
	
 
}
