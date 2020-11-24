package br.com.stefanini.maratonadev.model.parser;

import br.com.stefanini.maratonadev.dto.AlugaDto;
import br.com.stefanini.maratonadev.model.Aluga;

public class AlugaParser {
	public static AlugaParser get() {
		return new AlugaParser();
	}
	
	public AlugaDto dto(Aluga entidade) {
		AlugaDto dto = new AlugaDto();
		
		dto.setCarro(entidade.getCarro());
		dto.setCliente(entidade.getCliente());
		dto.setData(entidade.getData());
		dto.setId(entidade.getId());
		
		return dto;
	}
	
	public Aluga entidade(AlugaDto dto) {
		Aluga entidade = new Aluga();
		
		entidade.setCarro(dto.getCarro());
		entidade.setCliente(dto.getCliente());
		entidade.setData(dto.getData());
		entidade.setId(dto.getId());
		
		return entidade;
	}
}
