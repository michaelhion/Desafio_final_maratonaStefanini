package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.panache.common.Sort;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:30
 */
@RequestScoped
public class CarroDao {
	@Inject
	EntityManager em;
	
    public List<Carro> listar(){
        return Carro.listAll(Sort.by("modelo,marca").ascending());
    }
    //modificações minhas 
    public void adicionarCarro(Carro carro) {
    	carro.persist(carro);
    }
    
    public Carro removeCarro(Carro carro) {
    	if(carro.isPersistent()) {
    		carro.delete();
    	}
    	return carro;
    }
    
    public Carro buscarPorPlaca(String placa) {
    	return Carro.findById(placa);
    }
    
    public Carro buscarClientePorCpf(Long cpf) {
    	return Carro.findById(cpf);
    }
    
//    public void inserirCliente(Long cpf, String placa) {
//    	Cliente cliente = buscarClientePorCpf(cpf);
//    	Carro carro = buscarPorPlaca(placa);
//    	carro.setCliente(cliente);
//    	
//    }
    
//    public void editarCliente(Carro carro, String placa, Long cpf) {    	
//    	String sql = "INSERIR_CLIENTE";
//		Query query = em.createNamedQuery(sql);
//		
//		query.setParameter("placa", carro.getPlaca());
//		query.setParameter("cliente", carro.getCliente());
//		
//		query.executeUpdate();
//    }
    
}
