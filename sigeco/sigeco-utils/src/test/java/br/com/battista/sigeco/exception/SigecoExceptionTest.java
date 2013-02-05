package br.com.battista.sigeco.exception;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class SigecoExceptionTest {
	
	@Test(expected = SigecoException.class)
	public void deveRetornaSigecoException() throws SigecoException {
		throw new SigecoException();
	}
	
	@Test(expected = SigecoException.class)
	public void deveRetornaSigecoExceptionQdoParametroExcecao()
			throws SigecoException {
		throw new SigecoException(new Exception());
	}
	
	@Test(expected = SigecoException.class)
	public void deveRetornaSigecoExceptionQdoParametroString()
			throws SigecoException {
		throw new SigecoException("Teste");
	}
	
	@Test(expected = SigecoException.class)
	public void deveRetornaSigecoExceptionQdoParametroStringEExcecao()
			throws SigecoException {
		throw new SigecoException("Teste", new Exception());
	}
	
}
