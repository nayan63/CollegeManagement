package com.mindtree.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.student.entity.Student;
import com.mindtree.student.exception.StudentFullException;
import com.mindtree.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService stuServe;
	
	@PostMapping
	public Student add(@RequestBody Student student) throws StudentFullException
	{
		return stuServe.add(student);
	}
	
	@GetMapping("/list")
	public List<Student> list()
	{
		return stuServe.list();
	}
	
	@GetMapping("/student-by-age/{stream}")
	public List<Student> listWithAgeAndStream(@PathVariable String stream)
	{
		return stuServe.byStreamAndAge(stream);
	}
	
	@GetMapping("/student-by-name/{collId}")
	public List<Student> listWithNameAndCollege(@PathVariable long collId)
	{
		return stuServe.byCollegeAndName(collId);
	}
	
	
	@PutMapping("/assign-college/{stuId}/{collId}")
	public Student assignCollege(@PathVariable long stuId,@PathVariable long collId) throws StudentFullException
	{
		return stuServe.collegeAssign(stuId, collId);
	}
}