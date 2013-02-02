package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos os tipos de paramêtros possíveis.
 *
 * @author rabsouza
 * @since 19/01/2013
 * @version 1.0
 *
 */
@SuppressWarnings("javadoc")
public enum TipoParametroEnum {

	APP_WEB("Aplicação Web"), SISTEMA("Sistema");

	private static final Map<String, TipoParametroEnum> LOOK_UP = new HashMap<String, TipoParametroEnum>();

	static {
		for (TipoParametroEnum tipoParametro : TipoParametroEnum.values()) {
			LOOK_UP.put(tipoParametro.getLabel(), tipoParametro);
		}
	}

	/**
	 * Retorna o enum.
	 *
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static TipoParametroEnum get(String label) {
		return LOOK_UP.get(label);
	}

	private String label;

	/**
	 * Construtor para a classe TipoParametroEnum.
	 *
	 * @param label
	 *            Texto que será impresso.
	 */
	private TipoParametroEnum(String label) {
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
