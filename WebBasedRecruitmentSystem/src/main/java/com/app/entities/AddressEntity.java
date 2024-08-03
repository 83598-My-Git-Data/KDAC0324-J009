package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Addresses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddressEntity {
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(length=6)
	private int pincode;
	
	@Column(length=50)
	private String state;
	
	@Column(length=50)
	private String country;
	
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="applicant_id", nullable=false)
	@MapsId
	private UserEntity user;

	public AddressEntity(String permanentAddress, int pincode, String state, String country, UserEntity user) {
		super();
		this.permanentAddress = permanentAddress;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
		this.user = user;
	}
	
	
	
	
}
