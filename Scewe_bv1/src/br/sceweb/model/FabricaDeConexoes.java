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
		} catch (SQLException e1) {
			try {
				connection = DriverManager.getConnection(url, "fatec", "fatec1010");
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return connection;	
	}
}
