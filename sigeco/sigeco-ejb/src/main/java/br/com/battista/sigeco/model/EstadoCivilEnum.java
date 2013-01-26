package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos os estados civis possíveis.
 *
 * @author rabsouza
 * @since 19/01/2013
 * @version 1.0
 *
 */
@SuppressWarnings("javadoc")
public enum EstadoCivilEnum {

	CASADO("Casado(a)"), NENHUM(""), SOLTEIRO("Solteiro(a)");

	private static final Map<String, EstadoCivilEnum> LOOK_UP = new HashMap<String, EstadoCivilEnum>();

	static {
		for (EstadoCivilEnum estadoCivil : EstadoCivilEnum.values()) {
			LOOK_UP.put(estadoCivil.getLabel(), estadoCivil);
		}
	}

	/**
	 * Retorna o enum.
	 *
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static EstadoCivilEnum get(String label) {
		return LOOK_UP.get(label);
	}

	private String label;

	/**
	 * Construtor para a classe EstadoCivilEnum.
	 *
	 * @param label
	 *            Texto que será impresso.
	 */
	private EstadoCivilEnum(String label) {
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
