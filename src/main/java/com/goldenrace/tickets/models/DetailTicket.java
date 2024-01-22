package com.goldenrace.tickets.models;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "DETAIL_TICKET")
public class DetailTicket extends DomainEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3543996177524853319L;
	
	@NotEmpty(message = "The description cannot be null or empty")
	@Size(min = 5, max = 120, message=" The description must be between 5 and 120 characters long ")
	private String description;
	
	@Min(0) 
	@Digits(integer = 50, fraction = 2)
	private Double amount;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "ticket_id")
	@JsonBackReference
	private Ticket ticket;
	
	
}
