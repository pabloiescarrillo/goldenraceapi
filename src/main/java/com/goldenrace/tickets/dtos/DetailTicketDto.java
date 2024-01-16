package com.goldenrace.tickets.dtos;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class DetailTicketDto {

	private Integer id;
	
	@NotEmpty
	private String description;
	
	@Min(0) 
	@Digits(integer = 50, fraction = 2)
	private Double amount;
	
	@NotNull
	private TicketDto ticket;
	
}
