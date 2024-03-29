package com.mindtree.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.college.VO.ResponseTemplate;
import com.mindtree.college.entity.College;
import com.mindtree.college.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeService collServe;
	
	@PostMapping
	public College add(@RequestBody College college)
	{
		return collServe.add(college);
	}
	
	@GetMapping("/list")
	public List<College> list()
	{
		return collServe.list();
	}
	
	@GetMapping("/total-student/{id}")
	public int totalStudent(@PathVariable long id)
	{
		return collServe.totalStudent(id);
	}
	
	@GetMapping("/list-student")
	public List<ResponseTemplate> listOfStudent()
	{
		return collServe.listOfStudent();
	}

}
