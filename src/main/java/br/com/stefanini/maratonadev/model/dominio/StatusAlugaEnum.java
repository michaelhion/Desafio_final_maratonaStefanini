package br.com.stefanini.maratonadev.model.dominio;

public enum StatusAlugaEnum {
	DISPONIVE("Carro disponivel para alugar"),
	ALUGADO("Carro locado no momento"),
	NAO_ESTA_ALUGANDO("Cliente disponivel para alugar carro"),
	MANUTENCAO("Carro indisponivel pois esta em manutenção");

	private String descricao;
	
	StatusAlugaEnum(String descricao){
		this.descricao = descricao;
	}
	
	
	public static Boolean isInvalido(String teste) {
		for(StatusAlugaEnum status: StatusAlugaEnum.values()) {
			if(status.name().equals(teste)) {
				return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
		
		
	}
}
