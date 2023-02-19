package com.ragh.sportsProject.layers.repository;

import com.ragh.sportsProject.layers.domain.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepositoryNew extends JpaRepository <Sport,Long>{

}
