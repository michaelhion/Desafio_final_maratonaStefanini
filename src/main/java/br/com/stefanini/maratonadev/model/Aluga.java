 package br.com.stefanini.maratonadev.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import br.com.stefanini.maratonadev.model.dominio.StatusAlugaEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntity;



@Entity
@Table(name = "aluga")
@SequenceGenerator(name = "aluga_seq", sequenceName = "aluga_id_aluga_seq", allocationSize = 1)
@NamedNativeQueries({
	@NamedNativeQuery(name = "INSERIR_ALUGUEL", query="INSERT INTO aluga (cliente_cpf,carro_placa)"
			+"VALUES (cliente_cpf = :cpf, carro_placa = :placa"),
	@NamedNativeQuery(name="ATUALIZAR_ALUGA", query= "UPDATE aluga"
			+" SET data = :data, cliente_cpf = :cliente_cpf, carro_placa = :carro_placa"
			+ " WHERE id = :id"),
})
public class Aluga extends PanacheEntity{
	
//	@Id
//	@Column(name = "aluga_id", unique = true, nullable = false)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluga_seq")
//	private Long id;
//	
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime data;
	
	
//	@ManyToOne
//	@JoinColumn(name = "cliente_cpf")
//	private Cliente cliente;
//
//	@ManyToOne
//	@JoinColumn(name = "carro_placa")
//	private Carro carro;
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusAlugaEnum status;
	
	@Column(name = "cliente_cpf", nullable = false)
	private Long cliente_cpf;
	
	@Column(name = "carro_placa", nullable = false)
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

	public StatusAlugaEnum getStatus() {
		return status;
	}

	public void setStatus(StatusAlugaEnum status) {
		this.status = status;
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
