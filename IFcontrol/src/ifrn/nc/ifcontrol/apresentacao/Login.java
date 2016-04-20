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
import java.awt.Dialog.ModalExclusionType;
import java.awt.Font;
import java.awt.SystemColor;

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
		setVisible(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
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
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(86, 43, 254, 170);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblUs = new JLabel("Usu\u00E1rio:");
		lblUs.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUs.setForeground(new Color(255, 255, 255));
		lblUs.setBounds(20, 36, 71, 17);
		panel.add(lblUs);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 261, 444, 10);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(0, 0, 444, 10);
		contentPane.add(panel_2);
	}
}
