package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Convenio;

public class UC05CadastrarConvenio {
	
	static Convenio convenio;
	static String dataInicio;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenio = new Convenio();
		dataInicio = "29/10/2015";
	}

	@Test
	public void test() {
		assertTrue(convenio.validaData(dataInicio));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
