package com.main.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
import org.aspectj.weaver.patterns.HasThisTypePatternTriedToSneakInSomeGenericOrParameterizedTypePatternMatchingStuffAnywhereVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.main.entity.Admin;

@Service
public class CarDaoImpl {
	@Autowired
	public CarDao dao;
	
	
	public ResponseEntity<Admin>  insert(Admin admin) {
		try {
			return new ResponseEntity<>(this.dao.save(admin),HttpStatus.CREATED) ;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;

		
	}
	
	public ResponseEntity<List<Admin>> insertAll(List<Admin> admin) {
		try {
			return new ResponseEntity<>( this.dao.saveAllAndFlush(admin),HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>( new ArrayList<>(),HttpStatus.CREATED);

	}
	
	public ResponseEntity<List<Admin>>   showAll(){	
		try {
			return new ResponseEntity<>(this.dao.findAll(),HttpStatus.OK) ;

		}catch (Exception e) 
		{
			e.printStackTrace();
		}
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST) ;
	}
	
	public List<Admin> showByRouteTo(String routeTo){
		return this.dao.findByRouteTo(routeTo);
	}
	
	public List<Admin> showByRouteFrom(String routeFrom){
		return this.dao.findByRouteFrom(routeFrom);
	}
	
	public ResponseEntity<String> delete(int id) {
		try {
			return new ResponseEntity<String>("Delete Successfull",HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ResponseEntity<String>("Delete unSuccesfull",HttpStatus.NOT_ACCEPTABLE);
	}
	
	public void deleteAll() {
		this.dao.deleteAllInBatch();
	}
	
	public Admin update(Admin admin,int id) {
		
		Admin adm = this.dao.getReferenceById(id);
		adm.setId(admin.getId());
		adm.setCarBrand(admin.getCarBrand());
		adm.setCarNumber(admin.getCarNumber());
		adm.setCustomer(admin.getCustomer());
		adm.setRoute_from(admin.getRoute_from());
		adm.setRoute_to(admin.getRoute_to());
		adm.setPaymentMode(admin.getPaymentMode());
		adm.setBookingDate(admin.getBookingDate());
		return this.dao.saveAndFlush(adm);

	}
	

}
