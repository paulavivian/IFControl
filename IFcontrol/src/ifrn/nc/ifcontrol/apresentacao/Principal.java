package ifrn.nc.ifcontrol.apresentacao;

import ifrn.nc.ifcontrol.apresentacao.table.SalaTableModel;
import ifrn.nc.ifcontrol.negocio.Sala;
import ifrn.nc.ifcontrol.persistencia.SalaDAO;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JEditorPane;

import java.awt.Label;
import java.awt.SystemColor;

public class Principal {

	private JFrame frmIfarcontrol;

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
					window.frmIfarcontrol.setVisible(true);
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
		frmIfarcontrol = new JFrame();
		frmIfarcontrol.setTitle("IFar-control");

		frmIfarcontrol.setIconImage(Toolkit.getDefaultToolkit().getImage(
				"img\\logo.png"));
		frmIfarcontrol.getContentPane().setBackground(Color.GRAY);
		frmIfarcontrol.setBackground(new Color(124, 252, 0));
		frmIfarcontrol.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmIfarcontrol.setResizable(true);
		frmIfarcontrol.setBounds(100, 100, 450, 300);
		frmIfarcontrol.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		frmIfarcontrol.setJMenuBar(menuBar);

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
		frmIfarcontrol.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 123, 1393, 398);
		frmIfarcontrol.getContentPane().add(panel);
		panel.setLayout(null);

		SalaDAO sDAO = new SalaDAO();
		List<Sala> salas = sDAO.buscarTodos();

		table = new JTable();
		table.setBounds(34, 42, 110, 80);
		panel.add(table);
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		String[] listOnOff = { "Liga", "Desliga" };
		table.setModel(new SalaTableModel(salas));
		final JComboBox ComboBox = new JComboBox(listOnOff);

		ComboBox.setBounds(715, 361, 75, 20);
		panel.add(ComboBox);

		JLabel lblTemperatura = new JLabel("Temperatura:");
		lblTemperatura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTemperatura.setForeground(new Color(255, 255, 255));
		lblTemperatura.setBounds(816, 361, 85, 20);
		panel.add(lblTemperatura);

		JLabel lblC = new JLabel("C\u00B0");
		lblC.setBounds(953, 361, 46, 20);
		panel.add(lblC);
		JSpinner spinner = new JSpinner();
		spinner.setBounds(903, 361, 46, 20);
		panel.add(spinner);

		JLabel lblSalas = new JLabel("Salas");
		lblSalas.setForeground(new Color(255, 255, 255));
		lblSalas.setBounds(59, 11, 75, 22);
		panel.add(lblSalas);
		lblSalas.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setBounds(714, 29, 431, 298);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblStatus_1 = new JLabel("Status:");
		lblStatus_1.setBounds(24, 69, 62, 34);
		panel_2.add(lblStatus_1);

		JLabel lblTemperatura_1 = new JLabel("Temperatura:");
		lblTemperatura_1.setBounds(24, 140, 77, 34);
		panel_2.add(lblTemperatura_1);

		// l_background.setIcon(new
		// javax.swing.ImageIcon(getClass().getResource("/nomeDoPacote/Tela.jpg"));
		// Icon icon = new ImageIcon(""img\\logo.png");
		// ((Window) icon).setBounds(87, 194, 62, 60);
		// panel_2.add(icon);

		JLabel lblStatus = new JLabel("Painel");
		lblStatus.setForeground(new Color(255, 255, 255));
		lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblStatus.setBackground(new Color(240, 240, 240));
		lblStatus.setBounds(881, 0, 85, 25);
		panel.add(lblStatus);

		JButton btnEnviar = new JButton("Alterar");
		btnEnviar.setBounds(996, 358, 96, 26);
		panel.add(btnEnviar);

		btnEnviar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				String valor = (String) (ComboBox.getSelectedItem());			
				String opcao = "sala_1";
				// String comando = "123";
					
				iniciarCliente("192.168.43.151", 1234);
				if(valor == "ligar"){
					JOptionPane.showMessageDialog(null, valor);
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
			}
			// ===================================//

		});

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(0, 662, 1376, 22);
		frmIfarcontrol.getContentPane().add(panel_1);

		temps.add("1");
		temps.add("2");

	}
}
