package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.tbm.TbmMachineDetails;
import com.ganesh.mahindra.model.tbm.TbmMachineLocation;

public interface TbmMachineDetailsRepository extends JpaRepository<TbmMachineDetails, Integer>{

	
	TbmMachineDetails save(TbmMachineDetails tbmMachineDetails);
	
	List<TbmMachineDetails> findByDelStatus(int delStatus);

	TbmMachineDetails findByDelStatusAndMachineId(int delStatus, int machineId);

	List<TbmMachineDetails> findByInt1AndDelStatus(int deptId, int delStatus);
}
