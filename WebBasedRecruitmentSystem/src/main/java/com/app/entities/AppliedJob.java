package com.app.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="applied-job")
@Getter
@Setter
@NoArgsConstructor

public class AppliedJob {
	
	@EmbeddedId
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private ApplicantJobId id;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@MapsId("applicant_id")
	@JoinColumn(name="applicant_id")
	private ApplicantEntity applicant;
	
	
	//jobInfoEntiy
	
	//jobStatus

}
