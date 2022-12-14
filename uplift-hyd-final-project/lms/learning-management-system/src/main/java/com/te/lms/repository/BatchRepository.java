package com.te.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch, String>{

	@Query(value = "select * from batch where status='ACTIVE'",nativeQuery = true)
	Optional<List<Batch>> getBatches();

}
