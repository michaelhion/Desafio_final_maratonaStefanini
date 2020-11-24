package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import br.com.stefanini.maratonadev.model.dominio.StatusAlugaEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;



@Entity
@Table(name = "aluga")
@NamedNativeQueries({
	@NamedNativeQuery(name="ATUALIZAR_ALUGA", query= "UPDATE aluga"
			+" SET data = :data, cliente = :cliente, carro = :carro"
			+ " WHERE id = :id"),
})
public class Aluga extends PanacheEntityBase{
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime data;
	
	
	@JoinColumn(name = "cliente_cpf")
	@OneToOne
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "carro_placa")
	private Carro carro;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusAlugaEnum status;
	
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

	public StatusAlugaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusAlugaEnum status) {
		this.status = status;
	}
	
	
}
