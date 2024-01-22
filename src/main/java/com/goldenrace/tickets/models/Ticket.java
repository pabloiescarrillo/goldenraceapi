package com.goldenrace.tickets.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Access(AccessType.FIELD)
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "TICKET")
public class Ticket extends DomainEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -105389852622219880L;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime creationDate;
	
	@Min(0) 
	@Digits(integer = 50, fraction = 2)
	private Double totalAmount;
	
	@OneToMany(mappedBy = "ticket")
	@JsonIgnore
	private List<DetailTicket> detailTickets;
}
