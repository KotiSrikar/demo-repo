package com.te.lms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.BatchDto;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.UpdateMentorDto;
import com.te.lms.email.Email;
import com.te.lms.response.RegistrationResponse;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class AdminController {

	private final AdminService adminService;
	private final Email email;

	@PostMapping(path = "/register/mentor")
	public RegistrationResponse<String> adminRegister(@RequestBody MentorDto mentorDto) {
		Optional<String> optionalmentor = adminService.register(mentorDto);
		if (optionalmentor.isPresent()) {
			String message = "Hello" + mentorDto.getMentorName()
					+ "you have been promoted from a employee to a mentor,please use these credentials for logging in \n"
					+ optionalmentor.get();
			String subject = "Congratulations";
			String emailId = mentorDto.getEmailId();
			email.sendEmail(message, emailId, subject);
			return new RegistrationResponse<String>("mentor has been registered Successfully");
		}
		throw new RuntimeException("unable to register the mentor");

	}

	@PostMapping(path = "/register/batch")
	public RegistrationResponse<String> newBatch(@RequestBody BatchDto batchDto) {
		Optional<String> optionalbatch = adminService.createBatch(batchDto);
		if (optionalbatch.isPresent()) {
			return new RegistrationResponse<String>("your batch has been Registered Successfully");
		}
		throw new RuntimeException("unable to Register your batch");
	}
	
	@PutMapping(path = "/update/{empId}")
	public RegistrationResponse<String> updateMentor(@RequestBody UpdateMentorDto updateMentorDto,@PathVariable(name = "empId") String empId){
		
		Optional<Boolean> optionalMentorId = adminService.updateMentor(updateMentorDto,empId);
		
		return new RegistrationResponse<String>("mentor is updated successfully");
	}
}
