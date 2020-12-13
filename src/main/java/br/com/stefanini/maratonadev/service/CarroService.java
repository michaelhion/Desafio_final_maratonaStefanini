package br.com.stefanini.maratonadev.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.stefanini.maratonadev.dao.CarroDao;
import br.com.stefanini.maratonadev.dto.CarroDto;
import br.com.stefanini.maratonadev.model.Carro;
import br.com.stefanini.maratonadev.model.parser.CarroParser;

/**
 * @author danilodorgam
 * @version 0.1.0
 * @created 29/10/2020 on 18:32
 */
@RequestScoped
public class CarroService {
    @Inject
    CarroDao dao;
    
    @Inject
    ClienteService serv;

    public List<CarroDto> listar(){
        return dao.listar().stream().map(CarroParser.get()::dto).collect(Collectors.toList());
    }
    
//    public void inserirCliente(Long cpf) {
//    	Cliente cliente = serv.buscarPorId(cpf);
//    	
//    }
    
//    @Transactional(rollbackOn = Exception.class)
//	public void editar(Long cpf, String placa, CarroDto dto) {
//		Carro carro = CarroParser
//				.get()
//				.entidade(dto);
//		Carro carroBanco = buscarPorPlaca(placa);
//		Carro carroCliente = buscarCliente(cpf);
//		carroBanco.setCliente(carro.getCliente());
//		
//		
//		dao.editarCliente(carroBanco, placa, cpf);
//	}
    
    public Carro buscarPorPlaca(String placa) {
    	Carro carro = dao.buscarPorPlaca(placa);
    	
    	return carro;
    }
    
    public Carro buscarCliente(Long cpf) {
    	Carro carro = dao.buscarClientePorCpf(cpf);
    	
    	return carro;
    }
}
