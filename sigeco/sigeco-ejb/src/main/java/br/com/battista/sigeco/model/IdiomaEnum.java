package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos idiomas possíveis.
 *
 * @author rabsouza
 * @since 19/01/2013
 * @version 1.0
 *
 */
@SuppressWarnings("javadoc")
public enum IdiomaEnum {

	PT_BR("Português Brasil");

	private static final Map<String, IdiomaEnum> LOOK_UP = new HashMap<String, IdiomaEnum>();

	static {
		for (IdiomaEnum idioma : IdiomaEnum.values()) {
			LOOK_UP.put(idioma.getLabel(), idioma);
		}
	}

	/**
	 * Retorna o enum.
	 *
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static IdiomaEnum get(String label) {
		return LOOK_UP.get(label);
	}

	private String label;

	/**
	 * Construtor para a classe IdiomaEnum.
	 *
	 * @param label
	 *            Texto que será impresso.
	 */
	private IdiomaEnum(String label) {
		this.label = label;
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
