package ifrn.nc.ifcontrol.persistencia;

import ifrn.nc.ifcontrol.negocio.Sala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
	Connection connection = null;
	PreparedStatement pst = null;
	ResultSet resultSet = null;

	public SalaDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = FabricaDeConexao.getInstance().getConnection();
		return conn;
	}

	public int Inserir(Sala sala) {
		try {
			String sql = "insert into Sala( ip, nome) values(?,?)";
			connection = getConnection();
			pst = connection.prepareStatement(sql);
			pst.setString(1, sala.getIp());
			pst.setString(2, sala.getNome());

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

	public List<Sala> buscarTodos() {
		// TODO Auto-generated method stub

		List<Sala> salas = new ArrayList<>();

		try {
			String queryString = "select * from Sala; ";
			connection = getConnection();
			pst = connection.prepareStatement(queryString);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				Sala sala = new Sala();
				sala.setNome(rs.getString(2));
				//sala.setIp(rs.getString(2));
				salas.add(sala);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finishConnection();
		}
		return salas;

	}

}