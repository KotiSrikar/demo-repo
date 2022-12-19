package com.te.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestListDto {

	private Integer Id;

	private String employeeId;

	private String employeeName;

	private Integer employeeYOP;

	private Double employeePercentage;

	private Integer employeeExperience;

	private Long contactNumber;

}
