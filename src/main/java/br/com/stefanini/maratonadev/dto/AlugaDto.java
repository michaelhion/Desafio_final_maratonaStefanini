package br.com.stefanini.maratonadev.dto;

import java.time.LocalDateTime;

import javax.json.bind.annotation.JsonbDateFormat;

import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.Cliente;

public class AlugaDto {
	private Long id;
	
	@JsonbDateFormat("dd/MM/yyyy HH:mm")
	private LocalDateTime data;
	
	private Cliente cliente;

	private Carro carro;
	
	private String status;
	
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
