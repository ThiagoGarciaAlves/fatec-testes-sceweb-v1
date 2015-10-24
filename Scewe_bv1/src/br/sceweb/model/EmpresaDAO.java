package br.sceweb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmpresaDAO {

	/*
	 * Inclui uma empresa no db
	 * entrada - objeto de uma empresa
	 * saida - o número de linhas afetadas com a operação
	 */
	public int adiciona(Empresa empresa) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("INSERT INTO empresa (cnpj, nomeDaEmpresa, nomeFantasia, endereco, telefone) VALUES (?,?,?,?,?)");
			ps.setString(1, empresa.getCnpj());
			ps.setString(2, empresa.getNomeDaEmpresa());
			ps.setString(3, empresa.getNomeFantasia());
			ps.setString(4, empresa.getEndereco());
			ps.setString(5, empresa.getTelefone());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return codigoRetorno;
	}

	/*
	 * Inclui uma empresa no db
	 * entrada - objeto de uma empresa
	 * saida - o número de linhas afetadas com a operação
	 */
	public int exclui(String cnpj) {
		PreparedStatement ps;
		int codigoRetorno = 0;
		
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("DELETE FROM empresa WHERE cnpj = ?");
			ps.setString(1, cnpj);
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return codigoRetorno;
	}
}
