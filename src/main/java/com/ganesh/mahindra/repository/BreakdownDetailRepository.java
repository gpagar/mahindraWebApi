package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.BreakdownDetail;
@Repository
public interface BreakdownDetailRepository extends JpaRepository<BreakdownDetail, Integer>{


	BreakdownDetail findBreakdownDetailById(int id);

}
