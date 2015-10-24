package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Controle;
import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC01CadastrarEmpresa {
	
	static Controle controle;
	
	static EmpresaDAO empresaDAO;
	static Empresa empresa;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controle = new Controle();
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Empresa X LTDA");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("Empresa X");
		empresa.setEndereco("Rua da empresa x, 382, Bairro A, Cidade B");
		empresa.setTelefone("65456546");
	}

	/**
	 * obj - verifica o comportamento do sistema na inclusão de uma empresa com sucesso
	 */
	@Test
	public void CT01UC01FBCadastra_empresa_com_sucesso() {
		controle.excluirEmpresa(empresa.getCnpj());
		assertEquals("cadastro realizado com sucesso", controle.cadastrarEmpresa(empresa.getCnpj(), empresa.getNomeDaEmpresa(), empresa.getNomeFantasia(), empresa.getEndereco(), empresa.getTelefone()));
		controle.excluirEmpresa(empresa.getCnpj());
	}

	/**
	 * obj - verifica o comportamento do sistema na inclusão de uma empresa com CNPJ já cadastrado
	 */
	@Test
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado() {
		controle.cadastrarEmpresa(empresa.getCnpj(), empresa.getNomeDaEmpresa(), empresa.getNomeFantasia(), empresa.getEndereco(), empresa.getTelefone());
		assertNotEquals("cadastro realizado com sucesso", controle.cadastrarEmpresa(empresa.getCnpj(), empresa.getNomeDaEmpresa(), empresa.getNomeFantasia(), empresa.getEndereco(), empresa.getTelefone()));
	}

	/**
	 * obj - verifica o comportamento do sistema na inclusão de uma empresa com CNPJ inválidos
	 */
	@Test
	public void CT03UC01A3Cadastra_empresa_com_cnpj_invalido() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setCnpj("8942423200018");
			fail("Deveria disparar uma exception");
		} catch(Exception e) {
			assertEquals("CNPJ inválido!", e.getMessage());
		}
	}

	/**
	 * obj - verifica o comportamento do sistema na inclusão de uma empresa com dados inválidos
	 */
	@Test
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setNomeDaEmpresa("");
			fail("Deveria disparar uma exception");
		} catch(Exception e) {
			assertEquals("nome da empresa inválido!", e.getMessage());
		}
	}
	
	/**
	 * obj - exclui o cnpj ao finalizar o teste
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		controle.excluirEmpresa(empresa.getCnpj());
	}

}
