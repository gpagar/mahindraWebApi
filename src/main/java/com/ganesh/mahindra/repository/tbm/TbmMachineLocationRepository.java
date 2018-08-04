package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.tbm.TbmMachineLocation;

public interface TbmMachineLocationRepository extends JpaRepository<TbmMachineLocation, Integer>{

	
	TbmMachineLocation save(TbmMachineLocation tbmMachineLocation);
	
	List<TbmMachineLocation> findByDelStatusAndMachineId(int delStatus, int machineId);
}
