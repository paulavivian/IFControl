package ifrn.nc.ifcontrol.persistencia;

import ifrn.nc.ifcontrol.negocio.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet resultSet = null;

	public UsuarioDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = FabricaDeConexao.getInstance().getConnection();
		return conn;
	}

	public int Inserir(Usuario usuario) {
		try {
			String sql = "insert into Usuario( matricula, nome, senha) values(?,?,?)";
			connection = getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, usuario.getMatricula());
			pst.setString(2, usuario.getNome());
			pst.setString(3, usuario.getSenha());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return 0;

	}

	private void finishConnection() {
		// TODO Auto-generated method stub
		try {
			if (pst != null)
				pst.close();
			if (connection != null)
				connection.close();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}