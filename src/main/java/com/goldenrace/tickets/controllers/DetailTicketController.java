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

import com.goldenrace.tickets.dtos.DetailTicketDto;
import com.goldenrace.tickets.dtos.TicketDto;
import com.goldenrace.tickets.mappers.DetailTicketMapper;
import com.goldenrace.tickets.models.DetailTicket;
import com.goldenrace.tickets.services.DetailTicketService;

import lombok.extern.slf4j.Slf4j;

/**
 * Controlador que maneja las operaciones relacionadas con los detalles de los tickets.
 *
 * Este controlador proporciona puntos finales para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * en los detalles de los tickets, como la b�squeda por identificador de ticket, b�squeda por identificador
 * de detalle, creaci�n, actualizaci�n y eliminaci�n.
 */
@Slf4j
@RestController
@RequestMapping("/api2")
public class DetailTicketController {
	
	
	@Autowired
	private DetailTicketService detailTicketService;
	@Autowired
	private DetailTicketMapper detailTicketMapper;
	
	/**
     * Endpoint para buscar detalles de tickets asociados a un ticket espec�fico.
     *
     * @param ticketId Identificador del ticket del cual se desean obtener los detalles.
     * @return Lista de detalles de tickets asociados al ticket especificado.
     */
	@GetMapping("/detailTickets/{id}")
	public List<DetailTicketDto> findByTicketId(@PathVariable("id") Integer id) {
		log.info("id controlador: " + id);
		return this.detailTicketMapper.detailTicketsToDetailTicketsDtos(this.detailTicketService.findByTicketId(id));
	}
	
	/**
     * Endpoint para buscar un detalle de ticket por su identificador.
     *
     * @param id Identificador del detalle de ticket que se desea buscar.
     * @return Detalle de ticket encontrado por su identificador.
     */
	@GetMapping("/detailTicket/{id}")
	public DetailTicketDto findById(@PathVariable("id") Integer id) {
		return this.detailTicketMapper.detailTicketToDetailTicketDto(this.detailTicketService.findById(id));
	}
	
	/**
     * Endpoint para crear un nuevo detalle de ticket.
     *
     * @param detailTicketDto Objeto DetailTicket que contiene la informaci�n del nuevo detalle de ticket.
     * @return Detalle de ticket reci�n creado.
     */
	@PostMapping("/detailTicket")
	public DetailTicketDto create(@RequestBody DetailTicketDto detailTicketDto) {
		return this.detailTicketMapper.detailTicketToDetailTicketDto(this.detailTicketService.save(this.detailTicketMapper.detailTicketDtoToDetailTicket(detailTicketDto)));
	}

	 /**
     * Endpoint para actualizar un detalle de ticket existente.
     *
     * @param id Identificador del detalle de ticket que se desea actualizar.
     * @param detailTicketDto Objeto DetailTicket con la informaci�n actualizada.
     * @return Detalle de ticket actualizado.
     * @throws ValidationException si el identificador proporcionado no coincide con el del objeto detailTicket.
     */
	@PutMapping("/detailTicket/{id}")
	public DetailTicketDto update(@PathVariable("id") Integer id, @RequestBody DetailTicketDto detailTicketDto) {
		
		if (!id.equals(detailTicketDto.getId())) 
			throw new ValidationException("ERROR: invalid identifier.");
		
		return this.detailTicketMapper.detailTicketToDetailTicketDto(this.detailTicketService.save(this.detailTicketMapper.detailTicketDtoToDetailTicket(detailTicketDto)));
		
		
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
