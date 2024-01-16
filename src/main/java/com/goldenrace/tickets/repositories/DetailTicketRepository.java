package com.goldenrace.tickets.repositories;

import org.springframework.stereotype.Repository;

import org.springframework.data.repository.CrudRepository;

import com.goldenrace.tickets.models.DetailTicket;

@Repository
public interface DetailTicketRepository extends CrudRepository<DetailTicket, Integer> {

}
