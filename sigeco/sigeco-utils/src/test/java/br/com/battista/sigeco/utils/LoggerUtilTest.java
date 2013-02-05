package br.com.battista.sigeco.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class LoggerUtilTest {
	
	@Test
	public void deveAddMDCLogger() {
		LoggerUtil.putMDC("teste", "teste");
	}
	
	@Test
	public void deveLimparTodosAppenders() {
		LoggerUtil.getLogger(LoggerUtilTest.class, PackageLog.TEST);
		LoggerUtil.clear();
		assertTrue(LoggerUtil.getAppenders().isEmpty());
	}
	
	@Test
	public void deveRemoveMDCLogger() {
		LoggerUtil.removeMDC("teste");
	}
	
	@Test
	public void deveRetornaLogger() {
		assertNotNull(LoggerUtil.getLogger(LoggerUtilTest.class,
				PackageLog.TEST));
	}
	
}
