package com.app.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor
@Entity
@Table(name="applicants")
public class ApplicantEntity extends BaseEntity {

	@OneToOne
	@JoinColumn(name="applicant_id")
	@MapsId("applicant_id")
	private UserEntity user;
	
	@Column(name="email_id_verify_status",columnDefinition = "BOOLEAN")
	private boolean emailIdVerfiyStatus;
	
	@Column(name="mobile_num_verify_status",columnDefinition = "BOOLEAN")
	private boolean mobileNumVerifyStatus;
	
	@Column(columnDefinition = "TEXT")
	private String resumeLink;
	
	@Column(columnDefinition = "TEXT")
	private String resumeHeadLine;
	
	@Column(columnDefinition = "TEXT")
	private String profileSummary;
	
	@Column(columnDefinition = "TEXT")
	private String profilePictureLink;
	
	@Column(length=6)
	private String maritalStatus;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private NoticePeriod noticePeriod;
	
	//list of skills that applicant has
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="applicant_skill",
			joinColumns =@JoinColumn(name="applicant_id"),
			inverseJoinColumns = @JoinColumn(name="skill_id"))
    private Set<SkillEntity> skills = new HashSet<>();
	
	//list of languages applicant can speak
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name="applicant_skill",
			joinColumns =@JoinColumn(name="applicant_id"),
			inverseJoinColumns = @JoinColumn(name="language_id"))
    private Set<LanguageEntity> languages = new HashSet<>();

	
	
	
}
