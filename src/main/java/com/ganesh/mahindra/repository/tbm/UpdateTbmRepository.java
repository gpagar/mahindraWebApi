package com.ganesh.mahindra.repository.tbm;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.tbm.UpdateTbm;

@Repository
public interface UpdateTbmRepository extends JpaRepository<UpdateTbm, Serializable>{

}
