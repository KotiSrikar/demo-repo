package com.te.lms.dto;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MentorDto {

	private String mentorName;
	
	private String employeeId;
	
	private String emailId;
	
	private List<SkillsDto> skillsDto = Lists.newArrayList();
}
