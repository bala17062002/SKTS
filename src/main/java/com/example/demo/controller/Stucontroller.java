package com.example.demo.controller;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Studentmodel;
import com.example.demo.service.Studentservice;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class Stucontroller {

//    Studentmodel
	@Autowired
	Studentservice serv;
	@GetMapping("allstudents")
	@ResponseBody
	public List<Studentmodel> getstu() {
		try {
		log.info("Getstudent method executed.");
		return serv.getAllStudent();
		}
		catch(Exception e) {
			log.warn("Error in getstumethod",e);
			return Collections.emptyList();
		}
	}
	@GetMapping("allstudents/{Id}")
	public Studentmodel getstudent(@PathVariable("Id") int sid) {
		log.info("Get method using Id as input was compiled");
		return serv.getstudent(sid);
	}
	@PostMapping("allstudents")
	public void addstu(@RequestBody Studentmodel Studentmodel) {
		log.info("post method was executed using addstu");
		serv.addjob(Studentmodel);
	}
	@GetMapping("allstudents/placed/{status}")
	public List<Studentmodel> getplaced(@PathVariable("status") String sta) {
		System.out.println("Entered into getBranch method with sbranch: {}"+ sta);
		return serv.getplaced(sta);
	}
	@GetMapping("allstudents/branch/{sbranch}")
	public List<Studentmodel> getBranch(@PathVariable("sbranch") String branch) {
//	    log.error("Entered into getBranch method with sbranch: {}", sbranch);
		System.out.println("branch method called");
		return serv.getbranch(branch);
	}
	@GetMapping("allstudents/name/{sname}")
	public  List<Studentmodel> getname(@PathVariable("sname") String name){
		return serv.getname(name);
	}
	@PutMapping("allstudents")
    public void updatestu(@RequestBody Studentmodel Studentmodel) {
		serv.updatestu(Studentmodel);
	}
    @DeleteMapping("allstudents/{sid}")
	public void deletestu(@PathVariable("sid") int sid) {
    	log.error("delete method called");
		serv.deletestu(sid);
	}
}
