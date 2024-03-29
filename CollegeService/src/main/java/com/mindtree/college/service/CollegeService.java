package com.mindtree.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.college.VO.ResponseTemplate;
import com.mindtree.college.entity.College;

@Service
public interface CollegeService {

	College add(College college);
	List<College> list();
	int totalStudent(long id);
	List<ResponseTemplate> listOfStudent();
	
}
