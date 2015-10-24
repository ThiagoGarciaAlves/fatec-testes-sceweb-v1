package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Controle;
import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC02ConsultarEmpresa {
	
	static Controle controle = new Controle();
	
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
	public void CT01UC02FBConsulta_empresa_com_sucesso() {
		empresaDAO.adiciona(empresa);
		Empresa empresa2 = empresaDAO.consultaEmpresa(empresa.getCnpj());
		assertTrue(empresa.equals(empresa2));
		controle.excluirEmpresa(empresa.getCnpj());
	}

	/**
	 * obj - verifica o comportamento do sistema na consulta de uma empresa com sucesso
	 */
	@Test
	public void CT02UC02FBConsulta_todas_empresas_com_sucesso() {
		Empresa empresa2 = new Empresa();
		empresa2.setCnpj("17945816000190");
		empresa2.setNomeDaEmpresa("Empresa X2 LTDA");
		controle.cadastrarEmpresa(empresa.getCnpj(), empresa.getNomeDaEmpresa(), empresa.getNomeFantasia(), empresa.getEndereco(), empresa.getTelefone());
		controle.cadastrarEmpresa(empresa2.getCnpj(), empresa2.getNomeDaEmpresa(), "", "", "");
		assertEquals(2, empresaDAO.consultaEmpresas().size());
		controle.excluirEmpresa(empresa.getCnpj());
		controle.excluirEmpresa(empresa2.getCnpj());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		controle.excluirEmpresa(empresa.getCnpj());
	}

}
