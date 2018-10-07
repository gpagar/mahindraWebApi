package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.tbm.TbmMachineItem;

public interface TbmMachineItemRepository extends JpaRepository<TbmMachineItem, Integer>{

	
	TbmMachineItem save(TbmMachineItem tbmMachineItem);
	
	List<TbmMachineItem> findByDelStatusAndLocationId(int delStatus, int locationId);

	TbmMachineItem findByDelStatusAndItemId(int i, int itemId);
}
