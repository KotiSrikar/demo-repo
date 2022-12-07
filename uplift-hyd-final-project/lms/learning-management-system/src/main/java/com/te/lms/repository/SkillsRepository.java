package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {


}
