package br.com.battista.sigeco;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.battista.sigeco.exception.SigecoExceptionTest;
import br.com.battista.sigeco.utils.FactoryTest;
import br.com.battista.sigeco.utils.LoggerUtilTest;
import br.com.battista.sigeco.utils.PackageLogTest;
import br.com.battista.sigeco.utils.PropertiesTest;
import br.com.battista.sigeco.utils.UtilCryptionTest;

@SuppressWarnings("javadoc")
@RunWith(Suite.class)
@SuiteClasses({ SigecoExceptionTest.class, FactoryTest.class,
		LoggerUtilTest.class, PackageLogTest.class, PropertiesTest.class,
		UtilCryptionTest.class })
public class AllTests {

}
