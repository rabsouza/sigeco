package br.com.battista.sigeco.utils;

import static junit.framework.Assert.assertNotNull;

import java.io.IOException;

import org.apache.log4j.Level;
import org.junit.Test;

import br.com.battista.sigeco.exception.SigecoException;

@SuppressWarnings("javadoc")
public class FactoryTest {

	@Test(expected=SigecoException.class)
	public void deveRetornaNullo() throws SigecoException {
		Factory.create(null);
	}

	@Test
	public void deveRetornaInstancia() throws SigecoException{
		assertNotNull(Factory.create(String.class));
	}

	@Test
	public void deveCriaApenderLog() throws IOException {
		assertNotNull(Factory.createAppender("teste.log", Level.ERROR,
				"%d{dd/MM/yyyy HH\\:mm\\:ss} %5p [%c{3}\\:%L] - %m%n"));
	}

}
