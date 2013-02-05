package br.com.battista.sigeco.test.validation;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import junit.framework.Assert;

import org.junit.Test;

@SuppressWarnings("javadoc")
public class BaseModelTest {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sigecoPU");
	
	@Test
	public void teste() {
		Assert.assertNotNull(emf.createEntityManager());
	}
	
}
