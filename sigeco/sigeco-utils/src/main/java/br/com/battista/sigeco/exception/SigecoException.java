package br.com.battista.sigeco.exception;

import org.apache.log4j.Logger;

import br.com.battista.sigeco.utils.LoggerUtil;
import br.com.battista.sigeco.utils.PackageLog;

/**
 * Classe para as exceções gerais.
 *
 * @author rabsouza
 * @since 20/01/2013
 * @version 1.0
 * @see Exception
 *
 */
public class SigecoException extends Exception {

	private static final long serialVersionUID = 6782959649862151106L;
	private static final Logger LOGGER = LoggerUtil.getLogger(
			SigecoException.class, PackageLog.UTIL);

	/**
	 * Construtor para a classe SigecoException.
	 *
	 */
	public SigecoException() {
		super();
	}

	/**
	 * Construtor para a classe SigecoException.
	 *
	 * @param message
	 */
	public SigecoException(String message) {
		super(message);
		LOGGER.error(message);
	}

	/**
	 * Construtor para a classe SigecoException.
	 *
	 * @param cause
	 */
	public SigecoException(Throwable cause) {
		super(cause);
		LOGGER.error(cause);
	}

	/**
	 * Construtor para a classe SigecoException.
	 *
	 * @param message
	 * @param cause
	 */
	public SigecoException(String message, Throwable cause) {
		super(message, cause);
		LOGGER.error(message, cause);
	}

}
