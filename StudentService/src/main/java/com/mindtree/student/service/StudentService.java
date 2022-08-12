package com.mindtree.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.student.entity.Student;
import com.mindtree.student.exception.StudentFullException;

@Service
public interface StudentService {

	Student add(Student student) throws StudentFullException;
	List<Student> list();
	Student collegeAssign(long stuId,long colId) throws StudentFullException;
	List<Student> byStreamAndAge(String stream);
	List<Student> byCollegeAndName(long collId);
}
