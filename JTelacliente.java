package projetocalcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JTelacliente extends JFrame {

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
	private JTextField textFieldNomeCli;
	private JTextField textFieldEndereco;
	private JTextField textFieldGenero;
	private JTextField textFieldIdade;
	private JTextField textFieldCodCli;
	private JTextField textFieldTotalGasto;
	private JTextField textFieldNumeroCompras;
	private JTextField textFieldMediaGastos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelacliente frame = new JTelacliente();
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
	public JTelacliente() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nome Cliente");
		lblNewLabel.setBounds(23, 47, 89, 14);
		contentPane.add(lblNewLabel);

		textFieldNomeCli = new JTextField();
		textFieldNomeCli.setBounds(163, 44, 148, 20);
		contentPane.add(textFieldNomeCli);
		textFieldNomeCli.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(23, 82, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(148, 79, 225, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setBounds(23, 122, 46, 14);
		contentPane.add(lblNewLabel_2);

		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(110, 119, 125, 20);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setBounds(23, 161, 46, 14);
		contentPane.add(lblNewLabel_3);

		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(110, 158, 86, 20);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Cod Cliente");
		lblNewLabel_4.setBounds(352, 47, 79, 14);
		contentPane.add(lblNewLabel_4);

		textFieldCodCli = new JTextField();
		textFieldCodCli.setBounds(441, 44, 86, 20);
		contentPane.add(textFieldCodCli);
		textFieldCodCli.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Total Gasto");
		lblNewLabel_5.setBounds(23, 205, 68, 14);
		contentPane.add(lblNewLabel_5);

		textFieldTotalGasto = new JTextField();
		textFieldTotalGasto.setBounds(110, 202, 86, 20);
		contentPane.add(textFieldTotalGasto);
		textFieldTotalGasto.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Numero de Compras");
		lblNewLabel_6.setBounds(23, 246, 130, 14);
		contentPane.add(lblNewLabel_6);

		textFieldNumeroCompras = new JTextField();
		textFieldNumeroCompras.setBounds(177, 243, 120, 20);
		contentPane.add(textFieldNumeroCompras);
		textFieldNumeroCompras.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Media Gastos");
		lblNewLabel_7.setBounds(23, 291, 78, 14);
		contentPane.add(lblNewLabel_7);

		textFieldMediaGastos = new JTextField();
		textFieldMediaGastos.setBounds(149, 288, 86, 20);
		contentPane.add(textFieldMediaGastos);
		textFieldMediaGastos.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Em Atraso");
		lblNewLabel_8.setBounds(23, 339, 68, 14);
		contentPane.add(lblNewLabel_8);

		JRadioButton rdbtnSim = new JRadioButton("Sim");
		rdbtnSim.setBounds(107, 335, 65, 23);
		contentPane.add(rdbtnSim);

		JRadioButton rdbtnNao = new JRadioButton("Não");
		rdbtnNao.setBounds(200, 335, 79, 23);
		contentPane.add(rdbtnNao);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {

			private String ematraso;

			public void actionPerformed(ActionEvent e) {

				Cliente c = new Cliente(textFieldNomeCli.getText(), textFieldEndereco.getText(),
						textFieldGenero.getText(), Integer.parseInt(textFieldIdade.getText()),
						textFieldCodCli.getText(), Double.parseDouble(textFieldTotalGasto.getText()),
						Integer.parseInt(textFieldNumeroCompras.getText()),
						Double.parseDouble(textFieldMediaGastos.getText()), Boolean.parseBoolean(ematraso));

				try {
					String sql = "insert into  projotacliente (NOME,ENDERECO,GENERO,IDADE,CODIGO_CLIENTE,TOTAL_GASTO,NUMERO_COMPRAS,MEDIA_GASTOS,EM_ATRASO)"
							+ " values (?,?,?,?,?,?,?,?,?)";
					pst = con.prepareStatement(sql);
					pst.setString(1, c.nome);
					pst.setString(2, c.endereco);
					pst.setString(3, c.genero);
					pst.setInt(4, c.idade);
					pst.setString(5, c.codigoCliente);
					pst.setDouble(6, c.totalGasto);
					pst.setInt(7, c.numeroCompras);
					pst.setDouble(8, c.mediaGastos);
					pst.setBoolean(9, c.emAtraso);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, " Cliente Cadastrado Com Sucesso ");

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnSalvar.setBounds(23, 386, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			Boolean emAtraso;

			public void actionPerformed(ActionEvent e) {

				Cliente c = new Cliente("", "", "", 0, textFieldCodCli.getText(), 0, 0, 0, true);

				try {
					pst = con.prepareStatement("Select * from projotacliente where codigo_cliente=?");
					pst.setString(1, c.codigoCliente);
					rs = pst.executeQuery();
					while (rs.next()) {
						c.nome = rs.getString("nome");
						c.endereco = rs.getString("endereco");
						c.genero = rs.getString("genero");
						c.idade = rs.getInt("idade");
						c.codigoCliente = textFieldCodCli.getText();
						c.totalGasto = rs.getInt("totalGasto");
						c.numeroCompras = rs.getInt("numeroCompras");
						c.mediaGastos = rs.getDouble("mediaGastos");
						c.emAtraso = rs.getBoolean("emAtraso");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				textFieldNomeCli.setText(c.nome);
				textFieldEndereco.setText(c.endereco);
				textFieldGenero.setText(c.genero);
				textFieldIdade.setText(Integer.toString(c.idade));
				textFieldCodCli.setText(c.codigoCliente);
				textFieldTotalGasto.setText(Double.toString(c.totalGasto));
				textFieldNumeroCompras.setText(Integer.toString(c.numeroCompras));
				textFieldMediaGastos.setText(Double.toString(c.mediaGastos));
				// textFieldEmAtraso.setText(Boolean.toString(c.emAtraso));
				// rdbtnSim.setSelected(c.emAtraso);

				if (emAtraso.equals("1"))
					rdbtnSim.setSelected(true);
				else
					rdbtnNao.setSelected(false);
			}
		});
		btnConsultar.setBounds(134, 386, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			

			private boolean emAtraso;

			public void actionPerformed(ActionEvent e) {
				
				Cliente c = new Cliente(textFieldNomeCli.getText(), textFieldEndereco.getText(),
						textFieldGenero.getText(), Integer.parseInt(textFieldIdade.getText()),
						textFieldCodCli.getText(), Double.parseDouble(textFieldTotalGasto.getText()),
						Integer.parseInt(textFieldNumeroCompras.getText()),
						Double.parseDouble(textFieldMediaGastos.getText()),emAtraso);
				
				
				if (rdbtnSim.isSelected())
					c.emAtraso=true;
				else
					c.emAtraso=true;
				
				textFieldNomeCli.setText("");
				textFieldEndereco.setText("");
				textFieldGenero.setText("");
				textFieldIdade.setText("");
				textFieldCodCli.setText("");
				textFieldTotalGasto.setText("");
				textFieldNumeroCompras.setText("");
				textFieldMediaGastos.setText("");
				rdbtnSim.isSelected();
			}
				
				
			
		});
		btnLimpar.setBounds(239, 386, 89, 23);
		contentPane.add(btnLimpar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(352, 386, 89, 23);
		contentPane.add(btnFechar);
	}
}
