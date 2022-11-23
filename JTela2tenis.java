package projetocalcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class JTela2tenis extends JFrame {

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
	private JTextField textFieldCodigo;
	private JTextField textFieldFabricante;
	private JTextField textFieldModelo;
	private JTextField textFieldPreco;
	private JTextField textFieldTamanho;
	private JTextField textFieldCor;
	private JTextField textFieldCategoria;
	private JTextField textFieldCor1;
	private JTextField textFieldCor2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTela2tenis frame = new JTela2tenis();
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
	public JTela2tenis() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 437, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(36, 44, 46, 14);
		contentPane.add(lblNewLabel);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(122, 41, 86, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fabricante");
		lblNewLabel_1.setBounds(36, 80, 65, 14);
		contentPane.add(lblNewLabel_1);

		textFieldFabricante = new JTextField();
		textFieldFabricante.setBounds(122, 72, 86, 20);
		contentPane.add(textFieldFabricante);
		textFieldFabricante.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setBounds(36, 117, 46, 14);
		contentPane.add(lblNewLabel_2);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(122, 114, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(36, 154, 46, 14);
		contentPane.add(lblNewLabel_3);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(122, 151, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tamanho");
		lblNewLabel_4.setBounds(36, 190, 46, 14);
		contentPane.add(lblNewLabel_4);

		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(122, 187, 86, 20);
		contentPane.add(textFieldTamanho);
		textFieldTamanho.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cor");
		lblNewLabel_5.setBounds(36, 232, 46, 14);
		contentPane.add(lblNewLabel_5);

		textFieldCor = new JTextField();
		textFieldCor.setBounds(122, 229, 86, 20);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Categoria");
		lblNewLabel_6.setBounds(36, 277, 65, 14);
		contentPane.add(lblNewLabel_6);

		textFieldCategoria = new JTextField();
		textFieldCategoria.setBounds(122, 274, 86, 20);
		contentPane.add(textFieldCategoria);
		textFieldCategoria.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Amortecimento");
		lblNewLabel_7.setBounds(23, 312, 78, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Cor 1");
		lblNewLabel_8.setBounds(36, 345, 46, 14);
		contentPane.add(lblNewLabel_8);

		textFieldCor1 = new JTextField();
		textFieldCor1.setBounds(122, 342, 86, 20);
		contentPane.add(textFieldCor1);
		textFieldCor1.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Cor 2");
		lblNewLabel_9.setBounds(36, 380, 46, 14);
		contentPane.add(lblNewLabel_9);

		textFieldCor2 = new JTextField();
		textFieldCor2.setBounds(122, 377, 86, 20);
		contentPane.add(textFieldCor2);
		textFieldCor2.setColumns(10);

		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(115, 308, 52, 23);
		contentPane.add(rdbtnSim);

		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(169, 308, 52, 23);
		contentPane.add(rdbtnNao);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnSim);
		grupo.add(rdbtnNao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			String amortecimento;

			public void actionPerformed(ActionEvent e) {

				if (rdbtnSim.isSelected())
					amortecimento = "Sim";
				else
					// if (rdbtnFeminino.isSelected())
					amortecimento = "Não";

				Tenis t = new Tenis(textFieldCodigo.getText(), textFieldFabricante.getText(), textFieldModelo.getText(),
						Double.parseDouble(textFieldPreco.getText()), Integer.parseInt(textFieldTamanho.getText()),
						textFieldCor.getText(), textFieldCategoria.getText(), Boolean.parseBoolean(amortecimento),
						textFieldCor1.getText(), textFieldCor2.getText());

				try {
					String sql = "insert into  projotatenis (CODIGO,FABRICANTE,MODELO,PRECO,TAMANHO,COR,CATEGORIA,AMORTECIMENTO,COR1,COR2)"
							+ " values (?,?,?,?,?,?,?,?,?,?)";
					pst = con.prepareStatement(sql);
					pst.setString(1, t.codigo);
					pst.setString(2, t.fabricante);
					pst.setString(3, t.modelo);
					pst.setDouble(4, t.preco);
					pst.setInt(5, t.tamanho);
					pst.setString(6, t.cor);
					pst.setString(7, t.categoria);
					pst.setBoolean(8, t.amortecimento);
					pst.setString(9, t.cor1);
					pst.setString(10, t.cor2);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso ");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSalvar.setBounds(23, 419, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			Boolean amortecimento;

			public void actionPerformed(ActionEvent e) {

				Tenis t = new Tenis(textFieldCodigo.getText(), "", "", 0, 0, "", "", true ,"","");
				
		

				try {
					pst = con.prepareStatement("Select * from projotatenis where codigo=?");
					pst.setString(1, t.codigo);
					rs = pst.executeQuery();
					while (rs.next()) {
						t.codigo = textFieldCodigo.getText();
						t.fabricante = rs.getString("fabricante");
						t.modelo = rs.getString("modelo");
						t.preco = rs.getDouble("preco");
						t.tamanho = rs.getInt("tamanho");
						t.cor = rs.getString("cor");
						t.categoria = rs.getString("categoria");
						t.amortecimento = rs.getBoolean("amortecimento");
						t.cor1 = rs.getString("cor1");
						t.cor2 = rs.getString("cor2");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				

				textFieldCodigo.setText(t.codigo);
				textFieldFabricante.setText(t.fabricante);
				textFieldModelo.setText(t.modelo);
				textFieldPreco.setText(Double.toString(t.preco));
				textFieldTamanho.setText(Integer.toString(t.tamanho));
				textFieldCor.setText(t.cor);
				textFieldCategoria.setText(t.categoria);
			    //rdbtnSim.setSelected(t.amortecimento);
				textFieldCor1.setText(t.cor1);
				textFieldCor2.setText(t.cor2);

				if (amortecimento.equals("1"))
					rdbtnSim.setSelected(true);
				else
					rdbtnNao.setSelected(false);
			}
		});
		btnConsultar.setBounds(122, 419, 89, 23);
		contentPane.add(btnConsultar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			Boolean amortecimento=true;
			public void actionPerformed(ActionEvent e) {
				
				Tenis t = new Tenis(textFieldCodigo.getText(), textFieldFabricante.getText(), textFieldModelo.getText(),
						Double.parseDouble(textFieldPreco.getText()), Integer.parseInt(textFieldTamanho.getText()),
						textFieldCor.getText(), textFieldCategoria.getText(),amortecimento,
						textFieldCor1.getText(), textFieldCor2.getText());
				
				if (rdbtnSim.isSelected())
					t.amortecimento=true;
				else
					t.amortecimento=true;
				
				textFieldCodigo.setText("");
				textFieldFabricante.setText("");
				textFieldModelo.setText("");
				textFieldPreco.setText("");
				textFieldTamanho.setText("");
				textFieldCor.setText("");
				textFieldCategoria.setText("");
			    rdbtnSim.isSelected();
				textFieldCor1.setText("");
				textFieldCor2.setText("");
			}
		});
		btnLimpar.setBounds(221, 419, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnNewButton = new JButton("Fechar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(320, 419, 89, 23);
		contentPane.add(btnNewButton);

	}
}
