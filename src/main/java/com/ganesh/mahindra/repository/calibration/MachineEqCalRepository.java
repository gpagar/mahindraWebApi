package com.ganesh.mahindra.repository.calibration;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.calibration.EqCalDetails;
@Repository
public interface MachineEqCalRepository extends JpaRepository<EqCalDetails, Integer> {



	List<EqCalDetails> findByDelStatusAndDeptId(int i, int deptId);

	EqCalDetails findByIdAndDelStatus(int id, int i);


}
