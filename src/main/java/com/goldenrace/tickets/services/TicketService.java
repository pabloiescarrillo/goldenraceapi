package com.goldenrace.tickets.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenrace.tickets.models.DetailTicket;
import com.goldenrace.tickets.models.Ticket;
import com.goldenrace.tickets.repositories.TicketRepository;

@Service
@Transactional
public class TicketService {
	
	@Autowired
	private TicketRepository repository;
	
	public List<Ticket> findAll() {
		return (List<Ticket>) this.repository.findAll();
	}

	public Ticket findById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	public Ticket save(Ticket ticket) {
		return this.repository.save(ticket);
	}

	public Ticket create() {
		Ticket result = new Ticket();
		result.setDetailTickets(new ArrayList<DetailTicket>());

		return result;
	}

	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

	public void delete(Ticket ticket) {
		this.repository.delete(ticket);
	}
	
	public List<Ticket> findByRangeOfDates(LocalDateTime to, LocalDateTime from){
		return this.repository.findByCreationDateBetween(to, from);
	}

}
