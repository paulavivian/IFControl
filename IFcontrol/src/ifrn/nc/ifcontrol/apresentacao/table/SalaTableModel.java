package ifrn.nc.ifcontrol.apresentacao.table;

import ifrn.nc.ifcontrol.negocio.Sala;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SalaTableModel extends AbstractTableModel {

	private List<Sala> dados;
	private String[] colunas = { "Salas" };

	public SalaTableModel(List<Sala> dados) {
		this.dados = dados;
	}

	public void addRow(Sala e) {
		this.dados.add(e);
		this.fireTableDataChanged();
	}

	public String getColumnName(int num) {
		return this.colunas[num];
	}

	@Override
	public int getRowCount() {
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		switch (coluna) {
		case 0:
			return dados.get(linha).getNome();
		case 1:
			return dados.get(linha).getNome();
		}
		return null;
	}

	/*public void ExcluirSala(int linha) {
		dados.remove(linha);
		fireTableRowsDeleted(linha, linha);
	}
*/
	public void AdicionarSala(int linha) {

		// fireTableRowsDeleted(linha, linha);
	}

}