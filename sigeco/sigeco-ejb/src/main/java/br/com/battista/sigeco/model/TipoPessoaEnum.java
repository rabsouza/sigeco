package br.com.battista.sigeco.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Representa todos os tipos de pessoas do sistema.
 *
 * @author Rafael
 * @version 1.0.0
 * @since 31/07/2010
 */
@SuppressWarnings("javadoc")
public enum TipoPessoaEnum {

	FIS("Pessoa Fisica"), JUR("Pessoa Juridica");

	private static final Map<String, TipoPessoaEnum> LOOK_UP = new HashMap<String, TipoPessoaEnum>();

	static {
		for (TipoPessoaEnum tipoPessoa : TipoPessoaEnum.values()) {
			LOOK_UP.put(tipoPessoa.getLabel(), tipoPessoa);
		}
	}

	/**
	 * Retorna o enum.
	 *
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static TipoPessoaEnum get(String label) {
		return LOOK_UP.get(label);
	}

	private String label;

	/**
	 * Construtor para a classe TipoPessoaEnum.
	 *
	 * @param label
	 *            Texto que será impresso.
	 */
	private TipoPessoaEnum(String label) {
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
