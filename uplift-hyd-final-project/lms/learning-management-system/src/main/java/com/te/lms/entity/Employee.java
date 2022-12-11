package com.te.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.checkerframework.common.aliasing.qual.Unique;

import com.te.lms.enums.Gender;
import com.te.lms.enums.Status;

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
@Table(name = "employee_primary_info")
public class Employee {
	@Id
	private String employeeId;
	private String employeeName;
	private LocalDate employeeDOJ;
	private LocalDate employeeDOB;
	
	@Unique
	private String employeeEmail;
	
	private String bloodGroup;
	private String designation;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String employeeNationality;
	@Enumerated(EnumType.STRING)
	private Status employeeStatus;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<AddressDetails> addressDetails;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<TechnicalSkills> technicalSkills;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Experience> experience;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Contact> contact;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Batch batch;
}
