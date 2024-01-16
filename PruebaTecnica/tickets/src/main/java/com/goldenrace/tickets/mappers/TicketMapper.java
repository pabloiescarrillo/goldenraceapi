package com.goldenrace.tickets.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldenrace.tickets.dtos.TicketDto;
import com.goldenrace.tickets.models.Ticket;
import com.goldenrace.tickets.services.TicketService;

@Component
@Mapper
public class TicketMapper {

	@Autowired
	private TicketService ticketService;

	public TicketDto ticketToTicketDto(Ticket ticket) {
		TicketDto result = null;

		if (ticket != null) {
			result = new TicketDto();
			result.setCreationDate(ticket.getCreationDate());
			result.setTotalAmount(ticket.getTotalAmount());
			result.setId(ticket.getId());
		}

		return result;
	}

	public Ticket ticketDtoToTicket(TicketDto ticketDto) {
		Ticket result = null;

		if (ticketDto != null && ticketDto.getId() == 0) {
			result = this.ticketService.create();
			result.setCreationDate(ticketDto.getCreationDate());
			result.setTotalAmount(ticketDto.getTotalAmount());
			result.setId(ticketDto.getId());
		} else if (ticketDto != null) {
			result = this.ticketService.findById(ticketDto.getId());
			result.setCreationDate(ticketDto.getCreationDate());
			result.setTotalAmount(ticketDto.getTotalAmount());
		}

		return result;
	}

	public List<TicketDto> ticketsToTicketsDtos(List<Ticket> tickets) {
		List<TicketDto> result = new ArrayList<>();

		if (tickets != null && !tickets.isEmpty()) {
			for (Ticket s : tickets)
				result.add(ticketToTicketDto(s));
		}

		return result;
	}

	public List<Ticket> ticketsDtosToTickets(List<TicketDto> ticketsDtos) {
		List<Ticket> result = new ArrayList<>();

		if (ticketsDtos != null && !ticketsDtos.isEmpty()) {
			for (TicketDto s : ticketsDtos)
				result.add(ticketDtoToTicket(s));
		}

		return result;
	}
}
