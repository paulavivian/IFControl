package ifrn.nc.ifcontrol.apresentacao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSpinner;
import javax.swing.Popup;
import javax.swing.JLabel;

import java.awt.Font;

public class Principal {

	private JFrame frame;

	private Socket cliente;

	// ===============================================//
	public void iniciarCliente(String ip, int porta) {
		try {
			cliente = new Socket(ip, porta);
			System.out.println("Cliente conectado no  Endereço: " + ip
					+ " e na porta: " + porta);
		} catch (IOException ex) {
			System.out.println("Erro");
		}
	}

	// ================================================//

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnGerenciar = new JMenu("Gerenciar");
		menuBar.add(mnGerenciar);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnGerenciar.add(mntmSair);

		JMenuItem cadastrar = new JMenuItem("cadastrar");
		cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Cadastro dialog = new Cadastro();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		mnGerenciar.add(cadastrar);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 1336, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(68, 98, 199, 98);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSala = new JLabel("Sala 1");
		lblSala.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSala.setBounds(72, 11, 70, 28);
		panel_2.add(lblSala);

		JButton btnOn = new JButton("Ligar");
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opcao = "ligar";
				// iniciarCliente("127.0.0.1", 3320);

				JOptionPane.showMessageDialog(null, opcao);
			}
		});
		btnOn.setBounds(10, 50, 76, 23);
		panel_2.add(btnOn);

		JButton btnDesligar = new JButton("Desligar");
		btnDesligar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String opcao = "desligar";
				// iniciarCliente("127.0.0.1", 3320);
				JOptionPane.showMessageDialog(null, opcao);

			}
		});
		btnDesligar.setBounds(96, 50, 93, 23);
		panel_2.add(btnDesligar);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(277, 98, 199, 98);
		panel.add(panel_3);

		JLabel lblSala_1 = new JLabel("Sala 2");
		lblSala_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSala_1.setBounds(72, 11, 70, 28);
		panel_3.add(lblSala_1);

		JButton button = new JButton("Ligar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = "ligar";
				// iniciarCliente("127.0.0.1", 3320);
				JOptionPane.showMessageDialog(null, opcao);
			}
		});
		button.setBounds(10, 50, 76, 23);
		panel_3.add(button);

		JButton button_1 = new JButton("Desligar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = "desligar";
				// iniciarCliente("127.0.0.1", 3320);
				JOptionPane.showMessageDialog(null, opcao);
			}
		});
		button_1.setBounds(96, 50, 93, 23);
		panel_3.add(button_1);

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(486, 98, 199, 98);
		panel.add(panel_4);

		JLabel lblSala_2 = new JLabel("Sala 3");
		lblSala_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSala_2.setBounds(72, 11, 70, 28);
		panel_4.add(lblSala_2);

		JButton button_2 = new JButton("Ligar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = "ligar";
				// iniciarCliente("127.0.0.1", 3320);
				JOptionPane.showMessageDialog(null, opcao);
			}
		});
		button_2.setBounds(10, 50, 76, 23);
		panel_4.add(button_2);

		JButton button_3 = new JButton("Desligar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcao = "desligar";
				// iniciarCliente("127.0.0.1", 3320);
				JOptionPane.showMessageDialog(null, opcao);
			}
		});
		button_3.setBounds(96, 50, 93, 23);
		panel_4.add(button_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 419, 1336, 254);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		String[] listOnOff = { "Liga", "Desliga" };
		JComboBox ComboBox = new JComboBox(listOnOff);

		ComboBox.setBounds(184, 60, 75, 20);
		panel_1.add(ComboBox);

		JSpinner spinner = new JSpinner();
		spinner.setBounds(120, 60, 44, 20);
		panel_1.add(spinner);

		JButton btnEnviar = new JButton("Liga/Desliga");
		btnEnviar.setBounds(383, 50, 124, 41);
		panel_1.add(btnEnviar);

		btnEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				try {
					ServerSocket server = new ServerSocket(3320);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				String opcao = "ligar";
				iniciarCliente("127.0.0.1", 3320);

				JOptionPane.showMessageDialog(null, opcao);

				try {
					PrintStream saida = new PrintStream(cliente
							.getOutputStream());
					saida.println(opcao);
				} catch (IOException ex) {
					System.out.println("Erro ao ligar");
				}
				try {
					cliente.close();
					System.out.println("Cliente desconectado!");
				} catch (IOException ex) {
					System.out.println("Erro ao fechar");
				}
			}

			// ===================================//

		});

	}
}
