package com.mindtree.student.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.student.entity.Student;
import com.mindtree.student.exception.StudentFullException;
import com.mindtree.student.repository.StudentRepository;
import com.mindtree.student.service.StudentService;

@Component
public class StudentImplement implements StudentService {

	@Autowired
	StudentRepository stuRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Student add(Student student) throws StudentFullException {
		long collId = student.getCollegeId();
		if(collId !=0)
		{
			Integer totalStudent = restTemplate.getForObject("http://COLLEGE-SERVICE/college/total-student/"+collId, Integer.class);
			if(totalStudent>stuRepo.totalStudentInCollege(collId))
			{
				return stuRepo.save(student);
			}
			else
			{
				throw new StudentFullException("Maximun Student reached in this college.Maximun size: "+totalStudent);
			}
		}
		
		return stuRepo.save(student);
	}

	@Override
	public List<Student> list() {
		return stuRepo.findAll();
	}

	@Override
	public Student collegeAssign(long stuId, long collId) throws StudentFullException {
		if(collId !=0)
		{
			Integer totalStudent = restTemplate.getForObject("http://COLLEGE-SERVICE/college/total-student/"+collId, Integer.class);
			if(totalStudent>stuRepo.totalStudentInCollege(collId))
			{
				Optional<Student> studentOp = stuRepo.findById(stuId);
				
				if(studentOp.isPresent())
				{
					Student student = studentOp.get();
					student.setCollegeId(collId);
					return stuRepo.save(student);
				}
				else
				{
					throw new StudentFullException("Student not found with ID: "+stuId);
				}
			}
			else
			{
				throw new StudentFullException("Maximun Student reached in this college.Maximun size: "+totalStudent);
			}
		}
		throw new StudentFullException("College id not given ");
	}

	@Override
	public List<Student> byStreamAndAge(String stream) {
		return stuRepo.getByStreamAge(stream);
	}
	
	@Override
	public List<Student> byCollegeAndName(long collId) {
		return stuRepo.getByCollegeIdName(collId);
	}

}