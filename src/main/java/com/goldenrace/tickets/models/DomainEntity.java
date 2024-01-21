package com.goldenrace.tickets.models;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Access(AccessType.FIELD)
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class DomainEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8995863217716611126L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	protected int id;
	
	@Version
	protected int version;
	
	
}
