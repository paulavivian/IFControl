package ifrn.nc.ifcontrol.apresentacao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Cadastro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastro dialog = new Cadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastro() {
		setBounds(100, 100, 450, 392);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCadastro = new JLabel("Cadastro");
			lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 17));
			lblCadastro.setBounds(173, 11, 116, 32);
			contentPanel.add(lblCadastro);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			panel.setBounds(49, 54, 351, 225);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNome = new JLabel("Nome");
				lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblNome.setBounds(21, 23, 58, 26);
				panel.add(lblNome);
			}
			{
				JLabel lblMatricula = new JLabel("Matricula");
				lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblMatricula.setBounds(21, 60, 58, 29);
				panel.add(lblMatricula);
			}
			{
				JLabel lblPerfil = new JLabel("Perfil");
				lblPerfil.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblPerfil.setBounds(21, 127, 58, 29);
				panel.add(lblPerfil);
			}
			{
				JLabel lblSenhaAdm = new JLabel("Senha Adm");
				lblSenhaAdm.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblSenhaAdm.setBounds(21, 167, 83, 29);
				panel.add(lblSenhaAdm);
			}
			{
				textField = new JTextField();
				textField.setBounds(120, 28, 140, 20);
				panel.add(textField);
				textField.setColumns(10);
			}
			{
				textField_1 = new JTextField();
				textField_1.setBounds(120, 66, 140, 20);
				panel.add(textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblSenha = new JLabel("Senha");
				lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
				lblSenha.setBounds(21, 100, 58, 21);
				panel.add(lblSenha);
			}
			{
				passwordField = new JPasswordField();
				passwordField.setBounds(120, 97, 140, 20);
				panel.add(passwordField);
			}
			{
				passwordField_1 = new JPasswordField();
				passwordField_1.setBounds(120, 173, 140, 20);
				panel.add(passwordField_1);
			}
			String[] perfil = { "Administrador", "Bolsista" };
			JComboBox comboBox = new JComboBox(perfil);
			comboBox.setBounds(120, 133, 109, 20);
			panel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Cadastrar");
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