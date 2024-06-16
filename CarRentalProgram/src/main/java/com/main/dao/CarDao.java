package com.main.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.main.entity.Admin;

@Repository
public interface CarDao extends JpaRepository<Admin, Integer>{
	
public List<Admin> findByRouteTo(String routeTo);
public List<Admin> findByRouteFrom(String routeFrom);


	
}
