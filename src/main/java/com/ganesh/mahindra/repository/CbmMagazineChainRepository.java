package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.cbm.CbmMagazineChain;

public interface CbmMagazineChainRepository extends JpaRepository<CbmMagazineChain, Integer>{

	List<CbmMagazineChain> findByStatusAndDeptId(int i, int deptId);

	List<CbmMagazineChain> findByYearEnd(String valueOf);
 
	

}
