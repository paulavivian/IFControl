package ifrn.nc.ifcontrol.apresentacao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Frame;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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
		mnGerenciar.add(mntmSair);

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
		scrollPane.setBounds(0, 0, 1336, 398);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 419, 1336, 254);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		String[] listOnOff = { "Liga", "Delisga" };
		JComboBox ComboBox = new JComboBox(listOnOff);
		ComboBox.setBounds(184, 60, 75, 20);
		panel_1.add(ComboBox);
	
        String [] temp = {"16", "17", "18"};
		JSpinner spinner = new JSpinner();
		spinner.setBounds(120, 60, 44, 20);
		panel_1.add(spinner);

	}
}
