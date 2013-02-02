package br.com.battista.sigeco.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

@SuppressWarnings("javadoc")
public class PackageLogTest {

	@Test
	public void deveRetornaLabel() {
		assertTrue(StringUtils.isNotBlank(PackageLog.DEFAULT.getLabel()));
	}

	@Test
	public void deveRetornaValor() {
		PackageLog packageLog = PackageLog.DEFAULT;
		assertEquals(packageLog, PackageLog.get(packageLog.getLabel()));
	}

}
