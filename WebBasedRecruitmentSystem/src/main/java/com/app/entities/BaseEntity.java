package com.app.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;


@MappedSuperclass  // to tell hib , not to create any tables n other entities will extend from it
@Getter
public class BaseEntity {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	

}
