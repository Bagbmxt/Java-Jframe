package projetocalcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class JTelapedido extends JFrame {

	// Database Connection
	private Connection con = null;
	private PreparedStatement pst;
	private ResultSet rs;

	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/cad?characterEncoding=utf8";
			String username = "root";
			String password = "21221";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNumeroPedido;
	private JTextField textFieldValorTotal;
	private JTextField textFieldNumeroItens;

	protected int numeroPedido;
	protected double valorTotal;
	protected double numeroItens;
	protected boolean pago = false;
	protected String vendedor;
	protected String comprador;
	
	/* Cliente */
	protected double totalGasto;
	protected int numeroCompras;
	protected double mediaGastos;
	
	/* Funcionário */
	protected double comissaoTotal;
	protected int numeroVendas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelapedido frame = new JTelapedido();
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
	public JTelapedido() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero Pedido");
		lblNewLabel.setBounds(24, 28, 83, 14);
		contentPane.add(lblNewLabel);

		textFieldNumeroPedido = new JTextField();
		textFieldNumeroPedido.setBounds(127, 25, 86, 20);
		contentPane.add(textFieldNumeroPedido);
		textFieldNumeroPedido.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Valor Total");
		lblNewLabel_1.setBounds(24, 67, 66, 14);
		contentPane.add(lblNewLabel_1);

		textFieldValorTotal = new JTextField();
		textFieldValorTotal.setBounds(127, 64, 86, 20);
		contentPane.add(textFieldValorTotal);
		textFieldValorTotal.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Numero Itens");
		lblNewLabel_2.setBounds(24, 108, 83, 14);
		contentPane.add(lblNewLabel_2);

		textFieldNumeroItens = new JTextField();
		textFieldNumeroItens.setBounds(127, 105, 86, 20);
		contentPane.add(textFieldNumeroItens);
		textFieldNumeroItens.setColumns(10);

		JCheckBox chckbxPedidoPago = new JCheckBox("Pedido Pago");
		chckbxPedidoPago.setBounds(21, 144, 97, 23);
		contentPane.add(chckbxPedidoPago);

		JLabel lblNewLabel_3 = new JLabel("Vendedor");
		lblNewLabel_3.setBounds(24, 174, 66, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Comprador");
		lblNewLabel_4.setBounds(24, 215, 66, 14);
		contentPane.add(lblNewLabel_4);
		
		
		JComboBox<?> comboBoxVendedor = new JComboBox();
		comboBoxVendedor.setBounds(119, 170, 134, 22);
		contentPane.add(comboBoxVendedor);
		
		JComboBox<?> comboBoxComprador = new JComboBox();
		comboBoxComprador.setBounds(119, 211, 134, 22);
		contentPane.add(comboBoxComprador);
		
		
		
		
		
		

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer.parseInt(textFieldNumeroPedido.getText());
				Double.parseDouble(textFieldValorTotal.getText());
				Double.parseDouble(textFieldNumeroItens.getText());
				Boolean.parseBoolean(chckbxPedidoPago.getText());
				vendedor = comboBoxComprador.getSelectedItem().toString();
				comprador = comboBoxVendedor.getSelectedItem().toString();
				//vendedor = textFieldVendedor.getText();
				//comprador = textFieldComprador.getText();
				
				if (chckbxPedidoPago.isSelected())
					pago = true;
				else
					pago = false;
			

				try {
					String sql = "insert into projotapedido (numero_pedido, valor_total, numero_itens,pago,vendedor,comprador) values (?,?,?,?,?,?)";
					pst = con.prepareStatement(sql);
					pst.setInt(1, numeroPedido);
					pst.setDouble(2,valorTotal);
					pst.setDouble(3,numeroItens);
					pst.setBoolean(4, pago);
					pst.setString(5, vendedor);
					pst.setString(6, comprador);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Pedido Cadastrado Com Sucesso ! ! ! ");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSalvar.setBounds(10, 265, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				numeroPedido = Integer.parseInt(textFieldNumeroPedido.getText());				
				try {
					pst = con.prepareStatement("select * from projotapedido where numeroPedido=?");
					pst.setInt(1, numeroPedido);					
					rs = pst.executeQuery();
					while (rs.next()) {
						
						valorTotal = rs.getDouble("valorTotal");
						numeroItens = rs.getInt("numeroItens");
						pago = rs.getBoolean("pago");
						vendedor = rs.getString("vendedor");
						comprador = rs.getString("comprador");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				textFieldValorTotal.setText(Double.toString(valorTotal));
				textFieldNumeroItens.setText(textFieldNumeroItens.toString());
				comboBoxVendedor.setSelectedItem(vendedor.toString());
				comboBoxComprador.setSelectedItem(comprador.toString());
				
				if (pago == true)
					chckbxPedidoPago.setSelected(true);
				else
					chckbxPedidoPago.setSelected(false);
				
			}
		});
		btnConsultar.setBounds(119, 265, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textFieldNumeroPedido.setText("");
				textFieldValorTotal.setText("");
				textFieldNumeroItens.setText("");
				chckbxPedidoPago.setSelected(false);
				
			}
		});
		btnLimpar.setBounds(227, 265, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(326, 265, 89, 23);
		contentPane.add(btnFechar);
	
	}
	
	public Vector<String> pesquisarCliente() {
		Vector<String> vetor = new Vector<String>();
		try {
			pst = con.prepareStatement("select * from cliente;");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				vetor.addElement(rs.getString("nome"));
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		/*System.out.println(vetor);*/
		return vetor;
		
		
	}
	
	public Vector<String> pesquisarFuncionario() {
		Vector<String> vetor = new Vector<String>();
		try {
			pst = con.prepareStatement("select * from funcionario;");
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				vetor.addElement(rs.getString("nome"));
			}
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return vetor;
		
		
	}
	
	public void comprar(double valorItem, int qtdItem, String cliente) {
		
		try {
			String sql = "select * from cliente where nome=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,cliente);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				totalGasto = rs.getDouble("totalGasto");
				numeroCompras = rs.getInt("numeroCompras");
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		double totalGastoAtual = valorItem * qtdItem;
		
		this.totalGasto += totalGastoAtual;
		
		this.numeroCompras += 1;
		
		double gastoMedio = this.totalGasto / this.numeroCompras;
		
		this.mediaGastos = gastoMedio;
		
		
		try {
			String sql = "update cliente set totalGasto=?, numeroCompras=? , mediaGastos=? where nome = ?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, totalGasto);
			pst.setInt(2, numeroCompras);
			pst.setDouble(3, mediaGastos);
			pst.setString(4, cliente);

			pst.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public void vender( double valorItem, int qtdItem, String funcionario) {
		
		try {
			String sql = "select * from funcionario where nome=?";
			pst = con.prepareStatement(sql);
			pst.setString(1,funcionario);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				comissaoTotal = rs.getDouble("comissaoTotal");
				numeroVendas = rs.getInt("numeroVendas");
				
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		this.comissaoTotal += (valorItem * qtdItem) * 0.02;
		this.numeroVendas += 1;
		
		
		try {
			String sql = "update funcionario set comissaoTotal=?, numeroVendas=? where nome = ?";
			pst = con.prepareStatement(sql);
			pst.setDouble(1, comissaoTotal);
			pst.setInt(2, numeroVendas);
			pst.setString(3, funcionario);

			pst.executeUpdate();
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}




