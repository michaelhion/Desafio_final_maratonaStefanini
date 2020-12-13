package br.com.stefanini.maratonadev.dto;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbDateFormat;

public class AlugaDto {
	private Long id;
	
	@JsonbDateFormat("dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	private Long cliente_cpf;
	
	private String carro_placa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Long getCliente_cpf() {
		return cliente_cpf;
	}

	public void setCliente_cpf(Long cliente_cpf) {
		this.cliente_cpf = cliente_cpf;
	}

	public String getCarro_placa() {
		return carro_placa;
	}

	public void setCarro_placa(String carro_placa) {
		this.carro_placa = carro_placa;
	}

	
}
