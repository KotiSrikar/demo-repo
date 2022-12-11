package com.te.lms.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.checkerframework.common.aliasing.qual.Unique;

import com.te.lms.enums.Action;

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
@Entity
public class RequestList {
	

	@Id
	private String employeeId;
	private String employeeName;
	
	private int employeeYOP;
	
	private double employeePercentage;
	
	
	private Integer Experience;
	
	private Long contactNumber;
	
	@Enumerated(EnumType.STRING)
	private Action action;

}
