package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.stefanini.maratonadev.model.Aluga;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class AlugaDao {
	@PersistenceContext
	EntityManager em;

	public List<Aluga> listarAluguel() {
		return Aluga.listAll(Sort.by("data").descending());
	}

	public Aluga buscarPorId(Long id) {
		return Aluga.findById(id);
	}

	@Transactional
	public void excluir(Long id) {
		Aluga.deleteById(id);
	}

	@Transactional
	public void inserirAluguel(Aluga aluguel) {
		aluguel.persistAndFlush();
	}

	@Transactional
	public void editar(Aluga aluga) {
		String sql = "ATUALIZAR_ALUGA";
		Query query = em.createNamedQuery(sql);

		query.setParameter("id", aluga.getId());
		query.setParameter("cliente", aluga.getCliente());
		query.setParameter("carro", aluga.getCarro());
		query.setParameter("data", aluga.getData());
		
		query.executeUpdate();
	}
}
