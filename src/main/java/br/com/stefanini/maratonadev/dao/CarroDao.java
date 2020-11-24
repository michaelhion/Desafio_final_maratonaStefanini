package br.com.stefanini.maratonadev.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.maratonadev.model.Carro;
import io.quarkus.panache.common.Sort;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:30
 */
@RequestScoped
public class CarroDao {

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
}
