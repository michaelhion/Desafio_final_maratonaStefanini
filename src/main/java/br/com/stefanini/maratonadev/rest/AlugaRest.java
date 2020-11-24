package br.com.stefanini.maratonadev.rest;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.maratonadev.dto.AlugaDto;
import br.com.stefanini.maratonadev.service.AlugaService;

@Path("aluga")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlugaRest {
	@Inject
	AlugaService service;
	
	@GET
	@Operation(summary = "Listar aluguel", description = "Lista de aluguel: data, cliente, carro")
	@APIResponse(responseCode = "201", description = "aluga", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AlugaDto.class)) })
	public Response listarAluguel() {
		return Response.status(Response.Status.OK).entity(service.listarAluga()).build();
	}
	
	@POST
	@Operation(summary = "Adicionar aluguel", description = "Inclusao de novo aluguel")
	@APIResponse(responseCode = "201", description = "aluga", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AlugaDto.class)) })
	public Response incluir(AlugaDto dto) {
		service.inserir(dto);
		
		return Response.status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Operation(summary = "Excluir um aluguel",
	description = "Excluir um aluguel")
	@APIResponse(responseCode = "202",
	description = "excluir",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = AlugaDto.class))
			})
	public Response excluir(@PathParam("id") Long id) {
		service.excluir(id);
		return Response
				.status(Response.Status.ACCEPTED)
				.build();
	}
	
	@GET
	@Path("/{id}")
	@Operation(summary = "Buscar um aluguel por id",
	description = "Buscar um aluguel por ID")
	@APIResponse(responseCode = "200",
	description = "aluguel",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = AlugaDto.class))
			})
	public Response buscarPorId(@PathParam("id")Long id) {
		return Response
				.status(Response.Status.OK)
				.entity(service.buscarPorId(id))
				.build();
	}
	
	@PUT
	@Path("/{id}")
	@Operation(summary = "Editar um aluguel com base no ID",
	description = "Editar um aluguel com base no ID")
	@APIResponse(responseCode = "200",
	description = "edição de aluguel",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = AlugaDto.class))
			}
	)
	@Transactional(rollbackOn = Exception.class)
	public Response editar(@PathParam("id") Long id, AlugaDto dto) {
		service.editar(id, dto);
		return Response
				.status(Response.Status.OK).entity(dto)
				.build();
	}
}
