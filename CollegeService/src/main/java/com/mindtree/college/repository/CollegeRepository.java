package com.mindtree.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.college.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

	@Query(value="SELECT total_student FROM college WHERE id=?1",nativeQuery = true)
	int getTotalStudent(long id);
}
