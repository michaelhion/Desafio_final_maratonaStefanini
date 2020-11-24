package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Cliente;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class ClienteDao {
	@PersistenceContext
	EntityManager em;
	
	public List<Cliente> listarClientes() {
		return Cliente.listAll(Sort.by("nome").descending());
	}
	
	public Cliente buscarPorId(Long cpf) {
		return Cliente.findById(cpf); 
	}
	
	public void inserirCliente(Cliente cliente) {
		cliente.persistAndFlush();
	}
	
	@Transactional
	public void excluir(Long cpf) {
		
		Cliente.deleteById(cpf);
	}
	
	@Transactional(rollbackOn = Exception.class)
	public void editar(Cliente cliente) {
		String sql = "ATUALIZAR_CLIENTE";
		Query query = em.createNamedQuery(sql);
		
		query.setParameter("cpf", cliente.getCpf());
		query.setParameter("nome", cliente.getNome());
		query.setParameter("endereco", cliente.getEndereco());
		query.setParameter("email", cliente.getEmail());
		query.setParameter("celular", cliente.getCelular());
		query.setParameter("telefone", cliente.getTelefone());
		query.setParameter("aluga", cliente.getAluga());
		query.setParameter("carro", cliente.getCarro());
		
		query.executeUpdate();
	}
}
