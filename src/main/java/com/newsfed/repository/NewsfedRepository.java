package com.newsfed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.newsfed.entity.Newsfed;

public interface NewsfedRepository extends JpaRepository<Newsfed, Long>{
	
	List<Newsfed> findBySentStatusAndDeleted(boolean sentStatus, boolean deleteStatus);

}
