package com.goldenrace.tickets.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldenrace.tickets.models.DetailTicket;
import com.goldenrace.tickets.repositories.DetailTicketRepository;

@Service
@Transactional
public class DetailTicketService {

	@Autowired
	private DetailTicketRepository repository;
	
	public List<DetailTicket> findAll() {
		return (List<DetailTicket>) this.repository.findAll();
	}

	public DetailTicket findById(int id) {
		return this.repository.findById(id).orElse(null);
	}

	public DetailTicket save(DetailTicket detailTicket) {
		return this.repository.save(detailTicket);
	}

	public DetailTicket create() {
		return new DetailTicket();
	}

	public void delete(Integer id) {
		this.repository.deleteById(id);
	}

	public void delete(DetailTicket detailTicket) {
		this.repository.delete(detailTicket);
	}
}
