package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

import br.com.stefanini.maratonadev.dao.AlugaDao;
import br.com.stefanini.maratonadev.dto.AlugaDto;
import br.com.stefanini.maratonadev.model.Aluga;
import br.com.stefanini.maratonadev.model.parser.AlugaParser;

@RequestScoped
public class AlugaService {
	@Inject
	AlugaDao dao;
	EntityManager em;
	
	public List<AlugaDto> listarAluga(){
		return dao.listarAluguel().stream().map(AlugaParser.get()::dto).collect(Collectors.toList());
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void inserir(Aluga aluga) {
		//Aluga aluga = AlugaParser.get().entidade(dto);
		dao.inserirAluguel(aluga);
	}
	
	public void excluir(Long id) {
		if(dao.buscarPorId(id)== null) {
			throw new NotFoundException();
		}
		dao.excluir(id);
	}
	
	/*@Transactional
	public void editar(Long id, AlugaDto dto) {
		Aluga aluga = AlugaParser
				.get()
				.entidade(dto);
		Aluga alugaBanco = buscarPorId(id);
		alugaBanco.setCarro(aluga.getCarro());
		alugaBanco.setCliente(aluga.getCliente());
		alugaBanco.setData(aluga.getData());
		alugaBanco.setId(aluga.getId());
		
		dao.editar(alugaBanco);
	}*/
	
	public Aluga buscarPorId(Long id) {
		Aluga aluga = dao.buscarPorId(id);
		if(aluga == null){
			throw new NotFoundException();
		}
		return aluga;
	}
}
