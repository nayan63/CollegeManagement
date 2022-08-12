package com.mindtree.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query(value="SELECT COUNT(id) AS total FROM student WHERE college_id=?1",nativeQuery = true)
	int totalStudentInCollege(long collId);
	
	@Query(value="SELECT * FROM student WHERE stream=?1 ORDER BY age DESC",nativeQuery = true)
	List<Student> getByStreamAge(String stream);
	
	@Query(value="SELECT * FROM student WHERE college_id=?1 ORDER BY name ASC",nativeQuery = true)
	List<Student> getByCollegeIdName(long collId);
}