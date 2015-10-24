package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC02ConsultarEmpresa {
	
	static EmpresaDAO empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa X LTDA");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Empresa X");
		empresa.setEndereco("Rua da empresa x, 382, Bairro A, Cidade B");
		empresa.setTelefone("65456546");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * obj - exclui o cnpj ao finalizar o teste
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui(empresa.getCnpj());
	}

}
