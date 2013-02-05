package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos os sexos.
 * 
 * @author rabsouza
 * @since 19/01/2013
 * @version 1.0
 * 
 */
@SuppressWarnings("javadoc")
public enum SexoEnum {
	
	F("Feminino"), M("Masculino");
	
	private static final Map<String, SexoEnum> LOOK_UP = new HashMap<String, SexoEnum>();
	
	private String label;
	
	static {
		for (SexoEnum sexo : SexoEnum.values()) {
			LOOK_UP.put(sexo.getLabel(), sexo);
		}
	}
	
	/**
	 * Construtor para a classe SexoEnum.
	 * 
	 * @param label
	 *            Texto que será impresso.
	 */
	private SexoEnum(String label) {
		this.label = label;
	}
	
	/**
	 * Retorna o enum.
	 * 
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static SexoEnum get(String label) {
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
