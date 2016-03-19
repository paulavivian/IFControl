package ifrn.nc.ifcontrol.apresentacao;

import ifrn.nc.ifcontrol.apresentacao.table.SalaTableModel;
import ifrn.nc.ifcontrol.negocio.Sala;
import ifrn.nc.ifcontrol.persistencia.SalaDAO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Principal {

	private JFrame frame;

	private Socket cliente;
	private JTable table;
	
	
	
	private List<String> temps = new ArrayList<String>();
	private String temp;
    
	// ===============================================//
	public void iniciarCliente(String ip, int porta) {
		try {
			cliente = new Socket(ip, porta);

			/*
			 * 1 - estabelecer uma conexao 2 - conversar 3 - linguagem
			 * (protocolo): "0- desligar,  1 -ligar, 2- alterar "
			 */
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
		frame.getContentPane().setBackground(new Color(173, 255, 47));
		frame.setBackground(new Color(124, 252, 0));
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setResizable(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 0, 0));
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

		JMenuItem cadastrarUsuario = new JMenuItem("cadastrar Usuário");
		cadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				CadastroUsuario dialog = new CadastroUsuario();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		mnGerenciar.add(cadastrarUsuario);

		JMenuItem cadastrarSala = new JMenuItem("cadastrar Sala");
		cadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroSala dialog = new CadastroSala();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});

		mnGerenciar.add(cadastrarSala);

		JMenu mnAjuda = new JMenu("Ajuda");
		menuBar.add(mnAjuda);

		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnAjuda.add(mntmSobre);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 123, 1393, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(SystemColor.text);
		scrollPane.setBounds(715, 25, 413, 325);
		panel.add(scrollPane);

		SalaDAO sDAO = new SalaDAO();
		List<Sala> salas = sDAO.buscarTodos();
		
				table = new JTable();
				table.setBounds(39, 37, 134, 80);
				panel.add(table);
				table.setForeground(new Color(0, 0, 0));
				table.setFont(new Font("Tahoma", Font.BOLD, 15));
				String[] listOnOff = { "Liga", "Desliga" };
						table.setModel(new SalaTableModel(salas));
						JComboBox ComboBox = new JComboBox(listOnOff);
						ComboBox.setBounds(715, 361, 75, 20);
						panel.add(ComboBox);
						
						JLabel lblTemperatura = new JLabel("Temperatura:");
						lblTemperatura.setBounds(816, 361, 85, 20);
						panel.add(lblTemperatura);
						
						JLabel lblC = new JLabel("C\u00B0");
						lblC.setBounds(953, 361, 46, 20);
						panel.add(lblC);
						
						JButton btnOk = new JButton("OK");
						btnOk.setBounds(976, 361, 59, 26);
						panel.add(btnOk);
						JSpinner spinner = new JSpinner();
						spinner.setBounds(903, 361, 46, 20);
						panel.add(spinner);
						
								JButton btnEnviar = new JButton("Liga/Desliga");
								btnEnviar.setBounds(380, 351, 124, 41);
								panel.add(btnEnviar);
								
										btnEnviar.addActionListener(new ActionListener() {
								
											public void actionPerformed(ActionEvent arg0) {
												String opcao = "sala_1";
								
												String comando = "123";
								
												iniciarCliente("192.168.43.151", 1234);
								
												// JOptionPane.showMessageDialog(null, opcao);
								
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

		

	  temps.add("1");
	  temps.add("2");

	}
}
