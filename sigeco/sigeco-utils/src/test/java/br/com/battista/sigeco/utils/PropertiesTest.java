package br.com.battista.sigeco.utils;

import static org.junit.Assert.assertTrue;

import java.util.MissingResourceException;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@SuppressWarnings("javadoc")
@RunWith(Enclosed.class)
public class PropertiesTest {

	public static class UtilizaMetodoGet {
		@Test
		public void deveRetornaPropriedade() {
			assertTrue(StringUtils.isNotBlank(Properties.get("teste")));
		}

		@Test
		public void deveRetornaPropriedadeQdoEnviadoParametro() {
			assertTrue(StringUtils
					.isNotBlank(Properties.get("teste1", "teste")));
		}

		@Test(expected = MissingResourceException.class)
		public void deveRetornaErroQdoNaoExistePropriedade() {
			StringUtils.isNotBlank(Properties.get("teste2"));
		}
	}

	public static class UtilizaMetodoLoadConfigProperties {
		@Test
		public void deveRetornaPropriedade() {
			assertTrue(StringUtils.isNotBlank(Properties
					.loadConfigProperties("teste")));
		}

		@Test
		public void deveRetornaPropriedadeQdoEnviadoParametro() {
			assertTrue(StringUtils.isNotBlank(Properties.loadConfigProperties(
					"teste1", "teste")));
		}

		@Test(expected = MissingResourceException.class)
		public void deveRetornaErroQdoNaoExistePropriedade() {
			StringUtils.isNotBlank(Properties.get("teste2"));
		}
	}

}
