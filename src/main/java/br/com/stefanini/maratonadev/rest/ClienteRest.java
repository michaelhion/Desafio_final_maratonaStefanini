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

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.service.ClienteService;

@Path("clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteRest {
	@Inject
	ClienteService service;

	@GET
	@Operation(summary = "Listar Clientes", description = "Lista de clientes: nome, endereço, email, telefone, cpf")
	@APIResponse(responseCode = "201", description = "cliente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response listarCliente() {
		return Response.status(Response.Status.OK).entity(service.listarCliente()).build();
	}

	@POST
	@Operation(summary = "Incluir Clientes", description = "Inclusao de clientes: nome, endereço, email, telefone, cpf")
	@APIResponse(responseCode = "201", description = "cliente", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response incluir(ClienteDto dto) {
		service.inserir(dto);

		return Response.status(Response.Status.CREATED).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Operation(summary = "Excluir um cliente",
	description = "Excluir um client")
	@APIResponse(responseCode = "202",
	description = "tarefa",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ClienteDto.class))
			}
	)
	public Response excluir(@PathParam("id") Long id) {
		service.excluir(id);
		return Response
				.status(Response.Status.ACCEPTED)
				.build();
	}
	
	
	@GET
	@Path("/{cpf}")
	@Operation(summary = "Buscar um cliente por cpf",
	description = "Buscar uma tarefa por ID")
	@APIResponse(responseCode = "200",
	description = "tarefa",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ClienteDto.class))
			}
	)
	public Response buscarPorID(@PathParam("cpf") Long cpf) {
		return Response
				.status(Response.Status.OK)
				.entity(service.buscarPorId(cpf))
				.build();
	}
//	
	
	
	@PUT
	@Path("/{cpf}")
	@Operation(summary = "Editar um cliente com base no ID",
	description = "Editar um cliente com base no ID")
	@APIResponse(responseCode = "200",
	description = "edição clientes",
	content = {
			@Content(mediaType =  "application/json",
			schema = @Schema(implementation = ClienteDto.class))
			}
	)
	@Transactional(rollbackOn = Exception.class)
	public Response editar(@PathParam("cpf") Long cpf, ClienteDto dto){
		
		service.editar(cpf, dto);
		return Response
				.status(Response.Status.OK).entity(dto)
				.build();
	}
	
	
}
