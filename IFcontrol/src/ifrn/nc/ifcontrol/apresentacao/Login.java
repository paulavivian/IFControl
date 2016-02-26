package ifrn.nc.ifcontrol.apresentacao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.JButton;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);

		setTitle("IF AR-CONTROL");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(184, 11, 54, 21);
		contentPane.add(lblLogin);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(86, 43, 254, 170);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUs = new JLabel("Usu\u00E1rio");
		lblUs.setBounds(20, 36, 59, 17);
		panel.add(lblUs);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(20, 84, 59, 17);
		panel.add(lblSenha);

		passwordField = new JPasswordField();
		passwordField.setBounds(101, 82, 103, 17);
		panel.add(passwordField);

		textField = new JTextField();
		textField.setBounds(101, 34, 103, 20);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(135, 125, 74, 30);
		panel.add(btnEntrar);
	}
}
