package com.ganesh.mahindra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.WhyWhyF18;

@Repository
public interface WhyWhyF18Repository extends JpaRepository<WhyWhyF18, Integer>{

	List<WhyWhyF18> findByMachineIdAndDelStatus(int machineId, int i);

}
