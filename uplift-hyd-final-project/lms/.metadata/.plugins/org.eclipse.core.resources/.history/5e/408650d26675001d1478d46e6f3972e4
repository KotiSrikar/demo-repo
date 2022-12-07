package com.te.lms.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.te.lms.enums.Action;
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
public class Batch {
	
	@Id
	private Integer batchId;
	
	private String batchName;
	
	@OneToOne(mappedBy = "batch",cascade = CascadeType.ALL)
	private Mentor mentor;
	
	private String technologies;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Status status;

}
