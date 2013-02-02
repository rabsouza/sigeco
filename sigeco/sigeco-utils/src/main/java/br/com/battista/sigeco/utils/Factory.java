package br.com.battista.sigeco.utils;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import br.com.battista.sigeco.exception.SigecoException;

/**
 * Fabrica de instancia do projeto.
 *
 * @author Rafael
 * @version 1.0.0
 * @since 18/07/2010
 */
public final class Factory {

	private static final Logger LOGGER = LoggerUtil.getLogger(Factory.class,
			PackageLog.UTIL);

	/**
	 * Cria uma nova instancia para um <em>{@link Object}</em>.
	 *
	 * @param obj
	 *            Class
	 * @return dao Object
	 * @throws SigecoException
	 */
	public static Object create(Class<?> obj) throws SigecoException {
		return getInstanceClass(obj);
	}

	/**
	 * Metodo <b>createDefaultAppender</b> possui a função de criar o appender
	 * para o log.
	 *
	 * @param fileName
	 *            Nome do arquivo de log.
	 * @param level
	 *            Level do log.
	 * @param conversionPattern
	 *            Pattern do log.
	 * @return appender Appender para o log.
	 * @throws IOException
	 *             Error ao tentar criar o appender.
	 */
	public static Appender createAppender(String fileName, Level level,
			String conversionPattern) throws IOException {

		PatternLayout layout = new PatternLayout();
		layout.setConversionPattern(conversionPattern);

		String fileDir = Properties.get("logger.file.dir");
		String fileSize = Properties.get("logger.file.size");
		int maxIndex = Integer.parseInt(Properties.get("logger.file.maxIndex"));

		RollingFileAppender appender = new RollingFileAppender(layout, fileDir
				+ fileName, true);
		appender.setName("file." + fileName);
		appender.setThreshold(level);
		appender.setEncoding("iso-8859-1");
		appender.setMaxFileSize(fileSize);
		appender.setMaxBackupIndex(maxIndex);
		appender.setImmediateFlush(true);
		appender.setBufferedIO(false);
		appender.setBufferSize(0);

		appender.activateOptions();

		return appender;
	}

	/**
	 * Método<strong>getInstanceClass(obj)</strong> possui a função de criar uma
	 * instância de uma classe ou de uma interface. <br>
	 * <strong>Ex.:</strong> <blockquote>
	 * <dl>
	 * <dt>Criar uma instância de uma classe através do {@link Factory}:</dt>
	 * <dt><code>ClasseX x = new ClasseX(); </code></dt>
	 * <dd><code>ClasseX x = Factory.create(ClasseX.class); </code></dd>
	 * </dl>
	 * <dl>
	 * <dt>Criar uma instância de uma interface através do {@link Factory}:</dt>
	 * <dt><strong>
	 * <code>public class ClasseX<em>Imp</em> implements InterfaceX...</code>
	 * </strong></dt>
	 * <dt><code>InterfaceX x = new ClasseX<em>Imp</em>(); </code>
	 * <dt>
	 * <dd><code>InterfaceX x = Factory.create(InterfaceX.class); </code></dd>
	 * </dl>
	 * </blockquote>
	 *
	 * @author rafael.batista
	 * @since 28/12/2010
	 * @param type
	 *            {@link Class} classe ou interface que será criado a instância.
	 * @return <strong>obj</strong> {@link Object} instância da classe,
	 *         interface ou {@link Object} quando ocorrer um error.
	 * @throws SigecoException
	 */
	private static Object getInstanceClass(Class<?> type) throws SigecoException {

		if (type == null) {
			throw new SigecoException("O paramêtro type não pode ser nulo.");
		}

		String name = type.getSimpleName();
		LOGGER.info("Criando uma nova instancia para " + name);

		if (!name.contains(Constant.SUFIX_CLASS_NAME)) {

			name += Constant.SUFIX_CLASS_NAME;
			String implClassName = type.getCanonicalName().replace(
					Constant.SPEC_PACKAGE_NAME, Constant.IMPL_PACKAGE_NAME)
					+ Constant.SUFIX_CLASS_NAME;

			try {
				try {
					return Class.forName(implClassName).newInstance();
				} catch (InstantiationException ex) {
					LOGGER.error("Erro ao tentar criar uma instancia para "
							+ name, ex);
				} catch (IllegalAccessException ex) {
					LOGGER.error("Erro ao tentar criar uma instancia para "
							+ name, ex);
				}

			} catch (ClassNotFoundException ex) {
				LOGGER.error("Erro ao tentar criar uma instancia para " + name,
						ex);
			}

		} else {

			String implClassName = type.getCanonicalName();
			try {
				try {

					return Class.forName(implClassName).newInstance();
				} catch (InstantiationException ex) {
					LOGGER.error("Erro ao tentar criar uma instancia para "
							+ name, ex);
				} catch (IllegalAccessException ex) {
					LOGGER.error("Erro ao tentar criar uma instancia para "
							+ name, ex);
				}

			} catch (ClassNotFoundException ex) {
				LOGGER.error("Erro ao tentar criar uma instancia para " + name,
						ex);
			}
		}

		return new Object();
	}

}
