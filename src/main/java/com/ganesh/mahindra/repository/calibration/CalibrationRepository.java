package com.ganesh.mahindra.repository.calibration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.TCalibration;

@Repository
public interface CalibrationRepository extends JpaRepository<TCalibration, Integer>{

}
