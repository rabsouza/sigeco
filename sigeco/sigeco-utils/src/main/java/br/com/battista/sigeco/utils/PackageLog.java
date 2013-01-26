package br.com.battista.sigeco.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Armazena o nome dos pacotes do logs.
 *
 * @author Rafa
 * @since 16/03/2012
 * @version 1.0.0
 *
 */
@SuppressWarnings("javadoc")
public enum PackageLog {

	DAO("dao"), DOMAIN("domain"), SERVICE("service"), TEST(
			"test"), WEB("web"), DEFAULT("sigeco"), UTIL("util");

	private static final Map<String, PackageLog> LOOK_UP = new HashMap<String, PackageLog>();

	static {
		for (PackageLog packageLog : PackageLog.values()) {
			LOOK_UP.put(packageLog.getLabel(), packageLog);
		}
	}

	/**
	 * Retorna o enum.
	 *
	 * @param label
	 *            Nome do label.
	 * @return enum.
	 */
	public static PackageLog get(String label) {
		return LOOK_UP.get(label);
	}

	private String label;

	/**
	 * Construtor para a classe PackageLog.
	 *
	 * @param label
	 *            Texto que será impresso.
	 */
	private PackageLog(String label) {
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
