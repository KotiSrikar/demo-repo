package com.te.lms.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateMentorDto {

	private String mentorName;
	
	private String employeeId;
	
	private String emailId;
	
	private List<SkillsDto> skillsDto;
	
	
}
