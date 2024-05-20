package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Studentmodel;
import com.example.demo.repo.Studentrepo;
@Service
public class Studentservice {
	Logger log=LoggerFactory.getLogger(Studentservice.class);
//	Studentmodel
    @Autowired
    private Studentrepo repo;
    public void addjob(Studentmodel Studentmodel) {
    	repo.save(Studentmodel);
    }
    public List<Studentmodel> getAllStudent(){
    	return repo.findAll();
    }
	public Studentmodel getstudent(int sId) {
		return repo.findById(sId).orElse(null);
	}
	public List<Studentmodel> getplaced(String sta) {
		return repo.findBystatus(sta);
	}
	public Studentmodel updatestu(Studentmodel Studentmodel) {
		// TODO Auto-generated method stub
		repo.save(Studentmodel);
		return Studentmodel;
	}
	public List<Studentmodel> getbranch(String sna) {
	    return repo.findBybranch(sna);
	}
	public void deletestu(int sid) {
		System.out.println("Hello delete");
        repo.deleteById(sid);	
	}
	public List<Studentmodel> getname(String name) {
		// TODO Auto-generated method stub
		return repo.findByname(name);
	}
}
