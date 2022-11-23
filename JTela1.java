package projetocalcado;

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
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class JTela1 extends JFrame {

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
	private JTextField textFieldMaterial;
	private JTextField textFieldEstilo;
	private JTextField textFieldSalto;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTela1 frame = new JTela1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 */
	public JTela1() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(23, 30, 46, 14);
		contentPane.add(lblNewLabel);

		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(105, 27, 86, 20);
		contentPane.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Fabricante");
		lblNewLabel_1.setBounds(23, 55, 59, 14);
		contentPane.add(lblNewLabel_1);

		textFieldFabricante = new JTextField();
		textFieldFabricante.setBounds(105, 58, 86, 20);
		contentPane.add(textFieldFabricante);
		textFieldFabricante.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Modelo");
		lblNewLabel_2.setBounds(23, 93, 46, 14);
		contentPane.add(lblNewLabel_2);

		textFieldModelo = new JTextField();
		textFieldModelo.setBounds(105, 90, 86, 20);
		contentPane.add(textFieldModelo);
		textFieldModelo.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Preço");
		lblNewLabel_3.setBounds(23, 135, 46, 14);
		contentPane.add(lblNewLabel_3);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(105, 132, 86, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Tamanho");
		lblNewLabel_4.setBounds(23, 172, 46, 14);
		contentPane.add(lblNewLabel_4);

		textFieldTamanho = new JTextField();
		textFieldTamanho.setBounds(105, 169, 86, 20);
		contentPane.add(textFieldTamanho);
		textFieldTamanho.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Cor");
		lblNewLabel_5.setBounds(23, 217, 46, 14);
		contentPane.add(lblNewLabel_5);

		textFieldCor = new JTextField();
		textFieldCor.setBounds(105, 214, 86, 20);
		contentPane.add(textFieldCor);
		textFieldCor.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Material");
		lblNewLabel_6.setBounds(23, 260, 46, 14);
		contentPane.add(lblNewLabel_6);

		textFieldMaterial = new JTextField();
		textFieldMaterial.setBounds(105, 257, 86, 20);
		contentPane.add(textFieldMaterial);
		textFieldMaterial.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Estilo");
		lblNewLabel_7.setBounds(23, 298, 46, 14);
		contentPane.add(lblNewLabel_7);

		textFieldEstilo = new JTextField();
		textFieldEstilo.setBounds(105, 295, 86, 20);
		contentPane.add(textFieldEstilo);
		textFieldEstilo.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Genero");
		lblNewLabel_8.setBounds(23, 341, 46, 14);
		contentPane.add(lblNewLabel_8);

		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(82, 337, 71, 23);
		contentPane.add(rdbtnMasculino);

		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBounds(170, 337, 109, 23);
		contentPane.add(rdbtnFeminino);

		JLabel lblNewLabel_9 = new JLabel("Salto");
		lblNewLabel_9.setBounds(23, 382, 46, 14);
		contentPane.add(lblNewLabel_9);

		textFieldSalto = new JTextField();
		textFieldSalto.setBounds(105, 382, 86, 20);
		contentPane.add(textFieldSalto);
		textFieldSalto.setColumns(10);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnMasculino);
		grupo.add(rdbtnFeminino);

		JButton btnSalvar = new JButton("Salvar");

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String genero;
				if (rdbtnMasculino.isSelected())
					genero = "M";
				else
					// if (rdbtnFeminino.isSelected())
					genero = "F";

				Sapato s = new Sapato(textFieldCodigo.getText(), textFieldFabricante.getText(),
						textFieldModelo.getText(), Double.parseDouble(textFieldPreco.getText()),
						Integer.parseInt(textFieldTamanho.getText()), textFieldCor.getText(),
						textFieldMaterial.getText(), textFieldEstilo.getText(), genero,
						Integer.parseInt(textFieldSalto.getText()));

				try {
					String sql = "insert into  projota1 (CODIGO,FABRICANTE,MODELO,PRECO,TAMANHO,COR,MATERIAL,ESTILO,GENERO,SALTO)"
							+ " values (?,?,?,?,?,?,?,?,?,?)";
					pst = con.prepareStatement(sql);
					pst.setString(1, s.codigo);
					pst.setString(2, s.fabricante);
					pst.setString(3, s.modelo);
					pst.setDouble(4, s.preco);
					pst.setInt(5, s.tamanho);
					pst.setString(6, s.cor);
					pst.setString(7, s.material);
					pst.setString(8, s.estilo);
					pst.setString(9, s.genero);
					pst.setInt(10, s.salto);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso Padrinho");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSalvar.setBounds(22, 434, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			String genero = "";

			public void actionPerformed(ActionEvent e) {

				Sapato s = new Sapato(textFieldCodigo.getText(), "", "", 0, 0, "", "", "", "", 0);

				try {
					pst = con.prepareStatement("Select * from projota1 where codigo=?");
					pst.setString(1, s.codigo);
					rs = pst.executeQuery();
					while (rs.next()) {
						s.codigo = textFieldCodigo.getText();
						s.fabricante = rs.getString("fabricante");
						s.modelo = rs.getString("modelo");
						s.preco = rs.getDouble("preco");
						s.tamanho = rs.getInt("tamanho");
						s.cor = rs.getString("cor");
						s.material = rs.getString("material");
						s.estilo = rs.getString("estilo");
						s.genero = rs.getString("genero");
						s.salto = rs.getInt("salto");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textFieldCodigo.setText(s.codigo);
				textFieldFabricante.setText(s.fabricante);
				textFieldModelo.setText(s.modelo);
				textFieldPreco.setText(Double.toString(s.preco));
				textFieldTamanho.setText(Integer.toString(s.tamanho));
				textFieldCor.setText(s.cor);
				textFieldMaterial.setText(s.material);
				textFieldEstilo.setText(s.estilo);
				textFieldSalto.setText(Integer.toString(s.salto));

				if (genero.equals("M"))
					rdbtnMasculino.setSelected(true);
				else
					rdbtnFeminino.setSelected(true);

			}
		});
		btnConsultar.setBounds(121, 434, 89, 23);
		contentPane.add(btnConsultar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			String genero = "";

			public void actionPerformed(ActionEvent e) {

				Sapato s = new Sapato(textFieldCodigo.getText(), textFieldFabricante.getText(),
						textFieldModelo.getText(), Double.parseDouble(textFieldPreco.getText()),
						Integer.parseInt(textFieldTamanho.getText()), textFieldCor.getText(),
						textFieldMaterial.getText(), textFieldEstilo.getText(), genero,
						Integer.parseInt(textFieldSalto.getText()));
				
				if (rdbtnMasculino.isSelected())
					s.genero="";
				else
					s.genero ="";

				textFieldCodigo.setText("");
				textFieldFabricante.setText("");
				textFieldModelo.setText("");
				textFieldPreco.setText("");
				textFieldTamanho.setText("");
				textFieldCor.setText("");
				textFieldMaterial.setText("");
				textFieldEstilo.setText("");
				textFieldSalto.setText("");
				rdbtnMasculino.isSelected();
				
				

			}
		});
		btnLimpar.setBounds(229, 434, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(328, 434, 89, 23);
		contentPane.add(btnFechar);

	}
}
