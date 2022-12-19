package com.te.lms.service;

import java.util.List;
import java.util.Optional;

import com.te.lms.dto.ApproveDto;
import com.te.lms.dto.BatchDto;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.MessageDto;
import com.te.lms.dto.RejectDto;
import com.te.lms.dto.RequestListDto;
import com.te.lms.dto.UpdateBatchDto;
import com.te.lms.dto.UpdateMentorDto;

public interface AdminService {

	Optional<String> register(MentorDto mentorDto);

	public Optional<String> createBatch(BatchDto batchDto);

	Optional<Boolean> updateMentor(UpdateMentorDto updateMentorDto, String empId);

	Boolean deleteMentor(String empId);

	Boolean deleteBatch(String batchId);

	Optional<MessageDto> ApproveEmployee(String empId, ApproveDto approveDto);

	Optional<List<MentorDto>> getMentors();

	Optional<List<BatchDto>> getBatchDetails();

	Optional<MessageDto> rejectEmployee(String empId, RejectDto rejectDto);

	Optional<Object> getEmployee(String employeeId);

	Optional<List<RequestListDto>> getRequestList();

	Boolean updateBatch(String batchId, UpdateBatchDto updateBatchDto);

}
