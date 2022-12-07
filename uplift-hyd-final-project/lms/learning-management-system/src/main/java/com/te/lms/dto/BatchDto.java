package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.te.lms.enums.Status;

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
public class BatchDto {
	
	private String batchId;
	
	private String batchName;
	
	private String mentorName;
	
	private List<TechnologiesDto> technologiesDto;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Status status;
}
