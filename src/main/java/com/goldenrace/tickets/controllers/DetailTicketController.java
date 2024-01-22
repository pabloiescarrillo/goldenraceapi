package com.goldenrace.tickets.controllers;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldenrace.tickets.models.DetailTicket;
import com.goldenrace.tickets.services.DetailTicketService;

/**
 * Controlador que maneja las operaciones relacionadas con los detalles de los tickets.
 *
 * Este controlador proporciona puntos finales para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * en los detalles de los tickets, como la búsqueda por identificador de ticket, búsqueda por identificador
 * de detalle, creación, actualización y eliminación.
 */
@RestController
@RequestMapping("/api2")
public class DetailTicketController {
	
	
	@Autowired
	private DetailTicketService detailTicketService;
	
	/**
     * Endpoint para buscar detalles de tickets asociados a un ticket específico.
     *
     * @param ticketId Identificador del ticket del cual se desean obtener los detalles.
     * @return Lista de detalles de tickets asociados al ticket especificado.
     */
	@GetMapping("/detailTickets/{ticketId}")
	public List<DetailTicket> findByTicketId(@PathVariable("ticketId") Integer ticketId) {
		return this.detailTicketService.findByTicketId(ticketId);
	}
	
	/**
     * Endpoint para buscar un detalle de ticket por su identificador.
     *
     * @param id Identificador del detalle de ticket que se desea buscar.
     * @return Detalle de ticket encontrado por su identificador.
     */
	@GetMapping("/detailTicket/{id}")
	public DetailTicket findById(@PathVariable("id") Integer id) {
		return this.detailTicketService.findById(id);
	}
	
	/**
     * Endpoint para crear un nuevo detalle de ticket.
     *
     * @param detailTicket Objeto DetailTicket que contiene la información del nuevo detalle de ticket.
     * @return Detalle de ticket recién creado.
     */
	@PostMapping("/detailTicket")
	public DetailTicket create(@RequestBody DetailTicket detailTicket) {
		return this.detailTicketService.save(detailTicket);
	}

	 /**
     * Endpoint para actualizar un detalle de ticket existente.
     *
     * @param id Identificador del detalle de ticket que se desea actualizar.
     * @param detailTicket Objeto DetailTicket con la información actualizada.
     * @return Detalle de ticket actualizado.
     * @throws ValidationException si el identificador proporcionado no coincide con el del objeto detailTicket.
     */
	@PutMapping("/detailTicket/{id}")
	public DetailTicket update(@PathVariable("id") Integer id, @RequestBody DetailTicket detailTicket) {
		
		if (!id.equals(detailTicket.getId())) 
			throw new ValidationException("ERROR: invalid identifier.");
		
		return this.detailTicketService.save(detailTicket);
		
		
	}

	/**
     * Endpoint para eliminar un detalle de ticket por su identificador.
     *
     * @param id Identificador del detalle de ticket que se desea eliminar.
     */
	@DeleteMapping("/detailTicket/{id}")
	public void delete(@PathVariable("id") Integer id) {
		this.detailTicketService.delete(id);
	}
	
}
