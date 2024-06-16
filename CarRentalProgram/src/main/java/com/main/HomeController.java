package com.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.dao.CarDaoImpl;
import com.main.entity.Admin;


@RestController
public class HomeController {
	
	@Autowired
	public CarDaoImpl carImpl;
	

	@GetMapping("/")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/cars")
	public ResponseEntity<List<Admin>>  showAlll(){
		return this.carImpl.showAll();
	}
	
	@GetMapping("/cars/{route_to}")
	public List<Admin> showByRouteTo(@PathVariable String route_to){
		return this.carImpl.showByRouteTo(route_to);
	}
	
	@GetMapping("/cars/routeFrom/{routeFrom}")
	public List<Admin> showByRouteFrom(@PathVariable String routeFrom){
		return this.carImpl.showByRouteFrom(routeFrom);
	}
	
	
	@PostMapping("/car")
	public ResponseEntity<Admin> add(@RequestBody Admin ad  ) {
	return	this.carImpl.insert(ad);
		
	}
	
	@PostMapping("/cars")
	public ResponseEntity<List<Admin>> addAll(@RequestBody List<Admin> ad  ) {
	return	this.carImpl.insertAll(ad);
		
	}
	
	@PutMapping("/car/{id}")
	public Admin updatee(@RequestBody Admin admin,@PathVariable String id) {		
		return this.carImpl.update(admin,Integer.parseInt(id));
	}
	
	
	@DeleteMapping("/car/{id}")
	public ResponseEntity<String> delete(@PathVariable String id) {	
		return 	carImpl.delete(Integer.parseInt(id));
	}
	
	@DeleteMapping("/cars")
	public String deleteAll() {
		this.carImpl.deleteAll();
		return "All Data Delete Successfull";
	}
	
}
