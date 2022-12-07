package com.te.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
	private String batchId;
	
	private String batchName;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "mentor_id")
	private Mentor mentor;
	
	@ManyToMany(mappedBy = "batch",cascade = CascadeType.ALL)
	private List<Technologies> technologies;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private Status status;

}
