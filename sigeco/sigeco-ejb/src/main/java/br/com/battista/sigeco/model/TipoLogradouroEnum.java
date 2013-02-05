package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos os tipos de logradouros possíveis.
 * 
 * @author rabsouza
 * @since 19/01/2013
 * @version 1.0
 * 
 */
@SuppressWarnings("javadoc")
public enum TipoLogradouroEnum {
	
	AV("Av."), NENHUM(""), RUA("Rua");
	
	private static final Map<String, TipoLogradouroEnum> LOOK_UP = new HashMap<String, TipoLogradouroEnum>();
	
	private String label;
	
	static {
		for (TipoLogradouroEnum tipoLogradouro : TipoLogradouroEnum.values()) {
			LOOK_UP.put(tipoLogradouro.getLabel(), tipoLogradouro);
		}
	}
	
	/**
	 * Construtor para a classe TipoLogradouroEnum.
	 * 
	 * @param label
	 *            Texto que será impresso.
	 */
	private TipoLogradouroEnum(String label) {
		this.label = label;
	}
	
	/**
	 * Retorna o enum.
	 * 
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static TipoLogradouroEnum get(String label) {
		return LOOK_UP.get(label);
	}
	
	/**
	 * @return label
	 */
	public String getLabel() {
		return label;
	}
	
	@Override
	public String toString() {
		return getLabel();
	}
	
}
