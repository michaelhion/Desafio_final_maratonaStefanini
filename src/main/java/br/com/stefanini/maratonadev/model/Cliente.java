package br.com.stefanini.maratonadev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "cliente")
@NamedNativeQueries({
	@NamedNativeQuery(name="ATUALIZAR_CLIENTE", query= "UPDATE cliente"
			+" SET nome = :nome, endereco = :endereco, email = :email, celular = :celular, telefone = :telefone"
			+ " WHERE cpf = :cpf"),
})
public class Cliente extends PanacheEntityBase{
	
//	@ManyToMany(mappedBy = "cliente")
//	private List<Carro> carro;
	
//	@OneToMany(mappedBy = "cliente")
//	private List<Aluga> aluga;
	
	@Id
	private Long cpf;
	

	@Column(name = "nome", nullable = false , length = 100)
//	@Min(message = "pelo menos 3 caracteres", value = 3)
	private String nome;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@Column(name = "email", nullable = false)
	private String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Cliente() {
		super();
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	

//	public List<Carro> getCarro() {
//		return carro;
//	}
//
//	public void setCarro(List<Carro> carro) {
//		this.carro = carro;
//	}

//	public List<Aluga> getAluga() {
//		return aluga;
//	}
//
//	public void setAluga(List<Aluga> aluga) {
//		this.aluga = aluga;
//	}
	
	
}
