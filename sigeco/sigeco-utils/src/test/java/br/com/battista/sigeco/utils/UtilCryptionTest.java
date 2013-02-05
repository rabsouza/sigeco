package br.com.battista.sigeco.utils;

import static org.junit.Assert.assertNotSame;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class UtilCryptionTest {
	
	@Test
	public void deveCriptografa() {
		String valor = "rafael";
		assertNotSame(valor, UtilCryption.encryption(valor));
	}
	
	@Test
	public void deveCriptografaParaMD5() {
		String valor = "rafael";
		assertNotSame(valor, UtilCryption.encryptionToMd5(valor));
	}
	
	@Test
	public void deveDescriptografa() {
		String valor = "311433883102338831013432.6";
		assertNotSame(valor, UtilCryption.decryption(valor));
	}
	
}
