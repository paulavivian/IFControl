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

public class Principal {

	private JFrame frame;

	private Socket cliente;
	private JTable table;

	// ===============================================//
	public void iniciarCliente(String ip, int porta) {
		try {
			cliente = new Socket(ip, porta);

/*
 *  1 - estabelecer uma conexao
 *  2 - conversar
 *  3 - linguagem (protocolo): "0- desligar,  1 -ligar, 2- alterar "
 * 
 * 
 * 
 * 
 * 
 * 
 * 
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
		panel.setBackground(Color.GRAY);
		panel.setBounds(10, 11, 1336, 398);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(493, 43, 348, 325);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	


		
		SalaDAO sDAO = new SalaDAO();
		List<Sala> salas = sDAO.buscarTodos();
		
		table.setModel(new SalaTableModel(salas));
		
		scrollPane.setViewportView(table);
		

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
