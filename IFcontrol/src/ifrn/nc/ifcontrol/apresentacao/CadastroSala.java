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
import java.awt.Color;

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
		setTitle("IFar-control");
		setBounds(100, 100, 300, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(173, 255, 47));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 0, 0));
			panel.setBounds(0, 75, 294, 87);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblIp = new JLabel("IP:");
				lblIp.setForeground(new Color(255, 255, 255));
				lblIp.setBounds(10, 0, 57, 27);
				panel.add(lblIp);
				lblIp.setFont(new Font("Tahoma", Font.BOLD, 15));
			}
			
					textIp = new JTextField();
					textIp.setBounds(87, 5, 158, 20);
					panel.add(textIp);
					textIp.setColumns(10);
					{
						JLabel lblNome = new JLabel("Nome:");
						lblNome.setForeground(new Color(255, 255, 255));
						lblNome.setBounds(10, 49, 57, 27);
						panel.add(lblNome);
						lblNome.setFont(new Font("Tahoma", Font.BOLD, 15));
					}
					
							textNome = new JTextField();
							textNome.setBounds(87, 54, 158, 20);
							panel.add(textNome);
							textNome.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.RED);
			panel.setBounds(0, 228, 294, 10);
			contentPanel.add(panel);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.RED);
			panel.setBounds(0, 0, 294, 10);
			contentPanel.add(panel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cadastrar");
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
