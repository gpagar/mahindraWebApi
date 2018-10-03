package com.ganesh.mahindra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ganesh.mahindra.model.MachinMaintanaceSchedule;

public interface MachinMaintanaceScheduleRepository extends JpaRepository<MachinMaintanaceSchedule, Integer>{

	MachinMaintanaceSchedule findByMachinIdAndDelStatus(int machineId, int delStatus);


	MachinMaintanaceSchedule findByMachinId(int machineId);

}
