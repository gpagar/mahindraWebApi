package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.tbm.TbmMachineDetails;

public interface TbmMachineDetailsRepository extends JpaRepository<TbmMachineDetails, Integer>{

	
	TbmMachineDetails save(TbmMachineDetails tbmMachineDetails);
	
	List<TbmMachineDetails> findByDelStatus(int delStatus);

	List<TbmMachineDetails> findByDelStatusOrderByMachineName(int i);
}
