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

	/**
	 * obj - verifica o comportamento do sistema na consulta de uma empresa com sucesso
	 */
	@Test
	public void test() {
		empresaDAO.adiciona(empresa);
		Empresa empresa2 = empresaDAO.consultaEmpresa(empresa.getCnpj());
		assertTrue(empresa.equals(empresa2));
		empresaDAO.exclui(empresa.getCnpj());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui(empresa.getCnpj());
	}

}
