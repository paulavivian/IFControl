package ifrn.nc.ifcontrol.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexao {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private String connectionUrl = "jdbc:mysql://localhost:3306/Ifcontrol";
	private String dbUser = "root";
	private String dbPwd = "root";

	private static FabricaDeConexao FabricaDeConexoes = null;

	private FabricaDeConexao() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static FabricaDeConexao getInstance() {
		if (FabricaDeConexoes == null) {
			FabricaDeConexoes = new FabricaDeConexao();
		}
		return FabricaDeConexoes;
	}

}
