package br.sceweb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaDeConexoes {
	public Connection getConnection() {
		Connection connection = null;
		String url = "jdbc:mysql://localhost/sceweb";
		try {
			connection = DriverManager.getConnection(url, "root", "aluno");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;	
	}
}
