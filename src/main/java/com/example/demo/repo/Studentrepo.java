package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Studentmodel;

public interface Studentrepo extends JpaRepository<Studentmodel, Integer> {
   List<Studentmodel> findByname(String name);
   List<Studentmodel> findBybranch(String branch);
   List<Studentmodel> findBystatus(String status);
}
