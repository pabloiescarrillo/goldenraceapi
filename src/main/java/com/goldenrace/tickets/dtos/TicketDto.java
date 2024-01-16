package com.goldenrace.tickets.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class TicketDto {
	
	private Integer id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime creationDate;
	private Double totalAmount;
	private List<DetailTicketDto> detailTickets;

}
