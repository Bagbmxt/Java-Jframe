package projetocalcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPrincipal frame = new JPrincipal();
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
	public JPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		menuBar.add(mnArquivo);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mnArquivo.add(mntmCadastrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Sapato");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTela1 frame = new JTela1();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(35, 23, 93, 51);
		contentPane.add(btnNewButton);
		
		JButton btnTenis = new JButton("Tenis");
		btnTenis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTela2tenis frame = new JTela2tenis();
				frame.setVisible(true);	
			}
		});
		btnTenis.setBounds(177, 23, 93, 51);
		contentPane.add(btnTenis);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTelacliente frame = new JTelacliente();
				frame.setVisible(true);
			}
		});
		btnCliente.setBounds(39, 86, 89, 51);
		contentPane.add(btnCliente);
		
		JButton btnFuncionario = new JButton("Funcionário");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTelafuncionario frame = new JTelafuncionario();
				frame.setVisible(true);
			}
		});
		btnFuncionario.setBounds(177, 85, 93, 52);
		contentPane.add(btnFuncionario);
		
		JButton btnPedido = new JButton("Pedido");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTelapedido frame = new JTelapedido();
				frame.setVisible(true);
				
			}
		});
		btnPedido.setBounds(108, 160, 93, 51);
		contentPane.add(btnPedido);
	}
}
