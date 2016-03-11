package ifrn.nc.ifcontrol.apresentacao;

import ifrn.nc.ifcontrol.negocio.Sala;
import ifrn.nc.ifcontrol.persistencia.SalaDAO;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CadastroSala extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textIp;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CadastroSala dialog = new CadastroSala();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CadastroSala() {
		setBounds(100, 100, 300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIp = new JLabel("IP:");
			lblIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIp.setBounds(33, 71, 57, 27);
			contentPanel.add(lblIp);
		}
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNome.setBounds(33, 109, 57, 27);
			contentPanel.add(lblNome);
		}

		textIp = new JTextField();
		textIp.setBounds(100, 76, 158, 20);
		contentPanel.add(textIp);
		textIp.setColumns(10);

		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(100, 114, 158, 20);
		contentPanel.add(textNome);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Sala s = new Sala();

						s.setIp(textIp.getText());
						s.setNome(textNome.getText());

						SalaDAO sd = new SalaDAO();
						sd.Inserir(s);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
