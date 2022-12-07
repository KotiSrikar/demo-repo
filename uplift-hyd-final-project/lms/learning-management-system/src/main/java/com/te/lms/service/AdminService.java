package com.te.lms.service;

import java.util.Optional;

import com.te.lms.dto.BatchDto;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.UpdateMentorDto;

public interface AdminService {

	Optional<String> register(MentorDto mentorDto);

	public Optional<String> createBatch(BatchDto batchDto);

	Optional<Boolean> updateMentor(UpdateMentorDto updateMentorDto, String empId);
}
