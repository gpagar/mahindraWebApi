package com.ganesh.mahindra.repository.tbm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.tbm.TbmMachine;

@Repository
public interface TbmMachineRepository extends JpaRepository<TbmMachine, Integer>{

	List<TbmMachine> findByDelStatus(int i);

	List<TbmMachine> findByDelStatusOrderByMachineName(int i);

}
