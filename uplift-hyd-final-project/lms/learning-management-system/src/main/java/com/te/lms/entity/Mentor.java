package com.te.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.google.common.collect.Lists;
import com.te.lms.enums.EmployeeStatus;

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
public class Mentor {
	
	private String mentorName;
	
	@Id
	private String employeeId;
	
	private String emailId;
	
	@OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
	private List<Skills> skills = Lists.newArrayList();
	
	@OneToOne(mappedBy = "mentor",cascade = CascadeType.ALL)
	private Batch batch;
	
	@Enumerated(EnumType.STRING)
	private EmployeeStatus mentorStatus;
}
