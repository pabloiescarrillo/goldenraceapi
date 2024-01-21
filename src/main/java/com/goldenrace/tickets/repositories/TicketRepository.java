package com.goldenrace.tickets.repositories;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.goldenrace.tickets.models.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Integer> {

	List<Ticket> findByCreationDateBetween(LocalDateTime to, LocalDateTime from);
	
	List<Ticket> findByTotalAmount(Double totalAmount);
}
