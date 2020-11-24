package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.ClienteDto;
import br.com.stefanini.maratonadev.model.Cliente;

public class ClienteParser {
	public static ClienteParser get() {
		return new ClienteParser();
	}
	
	public ClienteDto dto(Cliente entidade) {
		ClienteDto dto = new ClienteDto();
		
		dto.setNome(entidade.getNome());
		dto.setEndereco(entidade.getEndereco());
		dto.setEmail(entidade.getEmail());
		dto.setCpf(entidade.getCpf());
		dto.setCelular(entidade.getCelular());
		dto.setTelefone(entidade.getTelefone());
	
		return dto;
	}
	
	public Cliente entidade(ClienteDto dto) {
		Cliente entidade = new Cliente();
		
		entidade.setNome(dto.getNome());
		entidade.setEndereco(dto.getEndereco());
		entidade.setEmail(dto.getEmail());
		entidade.setCpf(dto.getCpf());
		entidade.setCelular(dto.getCelular());
		entidade.setTelefone(dto.getTelefone());
	
		return entidade;
	}
	
	
}
