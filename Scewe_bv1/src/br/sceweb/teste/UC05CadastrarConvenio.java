package br.sceweb.teste;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.joda.time.format.DateTimeFormatter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Convenio;
import br.sceweb.model.ConvenioDAO;

public class UC05CadastrarConvenio {
	
	static ConvenioDAO convenioDAO;
	static Convenio convenio;
	static String dataInicio;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		convenioDAO = new ConvenioDAO();
		convenio = new Convenio();
		dataInicio = "29/10/2015";
	}
	
	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso_data_valida() {
		dataInicio = "29/10/2015";
		assertTrue(convenio.validaData(dataInicio));
	}
	
	@Test
	public void CT02UC05CadastrarConvenio_com_data_invalida() {
		dataInicio = "42/04/2015";
		assertFalse(convenio.validaData(dataInicio));
	}
	
	@Test
	public void CT03UC05CadastrarConvenio_com_sucesso_data_valida() {
		dataInicio = "29/10/2015";
		convenio.setDataInicio(dataInicio);
		assertTrue(dataInicio.equals(convenio.getDataInicio().toString("dd/MM/yyyy")));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void CT04UC05CadastrarConvenio_com_data_invalida() {
		convenio.setDataInicio("242/10/2015");
	}
	
	@Test
	public void CT05UC05CadastrarConvenio_com_sucesso() {
		convenioDAO.adiciona(convenio);
		assertEquals(1, convenioDAO.adiciona(convenio));
		convenioDAO.exclui(convenio.getCnpj());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
