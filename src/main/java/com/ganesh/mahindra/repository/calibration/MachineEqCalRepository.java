package com.ganesh.mahindra.repository.calibration;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.calibration.EqCalDetails;
@Repository
public interface MachineEqCalRepository extends JpaRepository<EqCalDetails, Integer> {


}
