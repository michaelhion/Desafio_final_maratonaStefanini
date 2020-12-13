package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.ClienteDao;
import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;
import br.com.stefanini.maratonadev.model.parser.ClienteParser;

@RequestScoped
public class ClienteService {
	@Inject
	ClienteDao dao;
	EntityManager em;
	
	@Inject
//	AlugaService serv;
	CarroService serv;

	public List<ClienteDto> listarCliente() {
		return dao.listarClientes().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());
	}

	@Transactional(rollbackOn = Exception.class)
	public void inserir(ClienteDto clienteDto) {
		// validação
		Cliente cliente = ClienteParser.get().entidade(clienteDto);
		dao.inserirCliente(cliente);
//		serv.inserir(cliente);
	}
	
	public void excluir(Long cpf) {
		//DESAFIO: VALIDAR SE ID é valido
		if(dao.buscarPorId(cpf) == null) {
			throw new NotFoundException();
		}
		dao.excluir(cpf);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void editar(Long cpf, ClienteDto dto) {
		Cliente cliente = ClienteParser
				.get()
				.entidade(dto);
		Cliente clienteBanco = buscarPorId(cpf);
		clienteBanco.setNome(cliente.getNome());
		clienteBanco.setEndereco(cliente.getEndereco());
		clienteBanco.setEmail(cliente.getEmail());
		clienteBanco.setCelular(cliente.getCelular());
		clienteBanco.setTelefone(cliente.getTelefone());
		clienteBanco.setNome(cliente.getNome());
		
		dao.editar(clienteBanco);
	}
	
	public Cliente buscarPorId(Long cpf) {
		Cliente cliente = dao.buscarPorId(cpf);
		if(cliente == null) {
			throw new NotFoundException();
		}
		return cliente;
	}
}
