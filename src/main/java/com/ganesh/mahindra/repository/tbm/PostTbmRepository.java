package com.ganesh.mahindra.repository.tbm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ganesh.mahindra.model.tbm.PostTbm;

@Repository
public interface PostTbmRepository extends JpaRepository<PostTbm, Integer> {

}
