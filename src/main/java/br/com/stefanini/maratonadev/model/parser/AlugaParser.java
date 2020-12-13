package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.AlugaDto;
import br.com.stefanini.maratonadev.model.Aluga;

public class AlugaParser {
	public static AlugaParser get() {
		return new AlugaParser();
	}
	
	public AlugaDto dto(Aluga entidade) {
		AlugaDto dto = new AlugaDto();
		
		dto.setCarro_placa(entidade.getCarro_placa());
		dto.setCliente_cpf(entidade.getCliente_cpf());
		dto.setData(entidade.getData());
		dto.setId(entidade.getId());
		
		return dto;
	}
	
	public Aluga entidade(AlugaDto dto) {
		Aluga entidade = new Aluga();
		
		entidade.setCarro_placa(dto.getCarro_placa());
		entidade.setCliente_cpf(dto.getCliente_cpf());
		entidade.setData(dto.getData());
		entidade.setId(dto.getId());
		
		return entidade;
	}
}
