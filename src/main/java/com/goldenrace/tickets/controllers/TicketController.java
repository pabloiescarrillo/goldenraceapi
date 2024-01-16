package com.goldenrace.tickets.controllers;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldenrace.tickets.dtos.RangeDto;
import com.goldenrace.tickets.dtos.TicketDto;
import com.goldenrace.tickets.mappers.TicketMapper;
import com.goldenrace.tickets.models.Ticket;
import com.goldenrace.tickets.services.TicketService;

@RestController
@CrossOrigin(origins = *")
@RequestMapping("/api")
public class TicketController {

	@Autowired
	private TicketMapper ticketMapper;
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/tickets")
	public List<Ticket> listAll() {
		return this.ticketService.findAll();
	}
	
	@GetMapping("/ticket/{id}")
	public TicketDto findById(@PathVariable("id") Integer id) {
		return this.ticketMapper.ticketToTicketDto(this.ticketService.findById(id));
	}
	
	@PostMapping("/tickets")
	public List<TicketDto> findByRange(@RequestBody RangeDto rangeDto) {
		return this.ticketMapper.ticketsToTicketsDtos(this.ticketService.findByRangeOfDates(rangeDto.getTo(), rangeDto.getFrom()));
	}
	
	@PostMapping("/ticket")
	public TicketDto create(@RequestBody TicketDto ticketDto) {
		return this.ticketMapper.ticketToTicketDto(this.ticketService.save(this.ticketMapper.ticketDtoToTicket(ticketDto)));
	}

	@PutMapping("/ticket/{id}")
	public TicketDto update(@PathVariable("id") Integer id, @RequestBody TicketDto ticketDto) {
		
		if (!id.equals(ticketDto.getId())) 
			throw new ValidationException("ERROR: invalid identifier.");
		
		return this.ticketMapper.ticketToTicketDto(this.ticketService.save(this.ticketMapper.ticketDtoToTicket(ticketDto)));
		
		
	}

	@DeleteMapping("/ticket/{id}")
	public void delete(@PathVariable("id") Integer id) {
		ticketService.delete(id);
	}
}
