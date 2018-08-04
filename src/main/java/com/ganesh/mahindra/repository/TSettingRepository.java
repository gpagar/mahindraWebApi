package com.ganesh.mahindra.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.TSetting;
@Repository
public interface TSettingRepository extends JpaRepository<TSetting, Integer>{

	TSetting findBySettingKey(String settingKey);
	

	@Transactional
	@Modifying
	@Query("UPDATE TSetting t SET t.settingValue =:settingValue  WHERE t.settingKey=:settingKey")
	int updateSetingValue(@Param("settingValue")int settingValue,@Param("settingKey") String settingKey);

}
