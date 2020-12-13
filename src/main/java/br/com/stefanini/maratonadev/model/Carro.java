package br.com.stefanini.maratonadev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:27
 */
@Entity
@Table(name = "carro")
@NamedNativeQueries({
	@NamedNativeQuery(name="INSERIR_CLIENTE", query= "INSERT INTO carro (cliente)"
			+" SELECT cpf= :cpf, nome = :nome, endereco = :endereco, email = :email, celular = :celular, telefone = :telefone"
			+ " WHERE placa = :placa AND cpf = :cpf"),
})
public class Carro extends PanacheEntityBase {

//	@ManyToMany
//	@JoinTable(name = "aluga", joinColumns = { @JoinColumn(name = "carro_placa") }, inverseJoinColumns = {
//			@JoinColumn(name = "cliente_cpf") })
//	private List<Cliente>cliente;
	
//	@OneToMany(mappedBy = "carro")
//	private List<Aluga> aluga;
	@Id
	private String placa;

	@Column(name = "ano")
	private int ano;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "marca")
	private String marca;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Carro(String placa) {
		this.placa = placa;
	}

	public Carro() {
		super();
	}

	

//	public List<Cliente> getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}

//	public List<Aluga> getAluga() {
//		return aluga;
//	}
//
//	public void setAluga(List<Aluga> aluga) {
//		this.aluga = aluga;
//	}

	
}
