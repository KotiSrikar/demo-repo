package com.te.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, String>{

	
	Optional<Mentor> findByMentorName(String mentorName);

	@Query(value = "select * from mentor where mentor_status='ACTIVE'",nativeQuery = true)
	Optional<List<Mentor>> getMentors();

	


	

}
