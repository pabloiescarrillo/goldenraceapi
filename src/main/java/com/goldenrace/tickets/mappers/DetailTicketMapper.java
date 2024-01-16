package com.goldenrace.tickets.mappers;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldenrace.tickets.dtos.DetailTicketDto;
import com.goldenrace.tickets.models.DetailTicket;
import com.goldenrace.tickets.services.DetailTicketService;


@Component
@Mapper
public class DetailTicketMapper {
	
	@Autowired
	private DetailTicketService detailTicketService;
	@Autowired
	private TicketMapper ticketMapper;

	public DetailTicketDto detailTicketToDetailTicketDto(DetailTicket detailTicket) {
		DetailTicketDto result = null;

		if (detailTicket != null) {
			result = new DetailTicketDto();
			result.setAmount(detailTicket.getAmount());
			result.setDescription(detailTicket.getDescription());
			result.setTicket(this.ticketMapper.ticketToTicketDto(detailTicket.getTicket()));
			result.setId(detailTicket.getId());
		}

		return result;
	}

	public DetailTicket detailTicketDtoToDetailTicket(DetailTicketDto detailTicketDto) {
		DetailTicket result = null;

		if (detailTicketDto != null && detailTicketDto.getId() == 0) {
			result = this.detailTicketService.create();
			result.setAmount(detailTicketDto.getAmount());
			result.setDescription(detailTicketDto.getDescription());
			result.setTicket(this.ticketMapper.ticketDtoToTicket(detailTicketDto.getTicket()));
			result.setId(detailTicketDto.getId());
		} else if (detailTicketDto != null) {
			result = this.detailTicketService.findById(detailTicketDto.getId());
			result.setAmount(detailTicketDto.getAmount());
			result.setDescription(detailTicketDto.getDescription());
			result.setTicket(this.ticketMapper.ticketDtoToTicket(detailTicketDto.getTicket()));
		}

		return result;
	}

	public List<DetailTicketDto> detailTicketsToDetailTicketsDtos(List<DetailTicket> detailTickets) {
		List<DetailTicketDto> result = new ArrayList<>();

		if (detailTickets != null && !detailTickets.isEmpty()) {
			for (DetailTicket s : detailTickets)
				result.add(detailTicketToDetailTicketDto(s));
		}

		return result;
	}

	public List<DetailTicket> detailTicketsDtosToDetailTickets(List<DetailTicketDto> detailTicketsDtos) {
		List<DetailTicket> result = new ArrayList<>();

		if (detailTicketsDtos != null && !detailTicketsDtos.isEmpty()) {
			for (DetailTicketDto s : detailTicketsDtos)
				result.add(detailTicketDtoToDetailTicket(s));
		}

		return result;
	}

}
