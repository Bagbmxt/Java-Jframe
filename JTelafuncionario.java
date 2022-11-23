package projetocalcado;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JTelafuncionario extends JFrame {
	
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
	private JTextField textFieldNome;
	private JTextField textFieldEndereco;
	private JTextField textFieldGenero;
	private JTextField textFieldIdade;
	private JTextField textFieldCodigoFuncionario;
	private JTextField textFieldSalario;
	private JTextField textFieldNumeroVendas;
	private JTextField textFieldComissaoTotal;
	private JButton btnConsultar;
	private JButton btnLimpar;
	private JButton btnFechar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JTelafuncionario frame = new JTelafuncionario();
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
	public JTelafuncionario() {
		Connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(21, 32, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(66, 29, 140, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(21, 66, 52, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldEndereco = new JTextField();
		textFieldEndereco.setBounds(76, 63, 86, 20);
		contentPane.add(textFieldEndereco);
		textFieldEndereco.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setBounds(21, 99, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setBounds(76, 96, 86, 20);
		contentPane.add(textFieldGenero);
		textFieldGenero.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Idade");
		lblNewLabel_3.setBounds(21, 135, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		textFieldIdade = new JTextField();
		textFieldIdade.setBounds(76, 132, 86, 20);
		contentPane.add(textFieldIdade);
		textFieldIdade.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cod Funcionario");
		lblNewLabel_4.setBounds(308, 32, 93, 14);
		contentPane.add(lblNewLabel_4);
		
		textFieldCodigoFuncionario = new JTextField();
		textFieldCodigoFuncionario.setBounds(411, 32, 86, 20);
		contentPane.add(textFieldCodigoFuncionario);
		textFieldCodigoFuncionario.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Salario");
		lblNewLabel_5.setBounds(21, 174, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setBounds(76, 171, 86, 20);
		contentPane.add(textFieldSalario);
		textFieldSalario.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Num Vendas");
		lblNewLabel_6.setBounds(21, 213, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		textFieldNumeroVendas = new JTextField();
		textFieldNumeroVendas.setBounds(106, 210, 86, 20);
		contentPane.add(textFieldNumeroVendas);
		textFieldNumeroVendas.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Comissão Total");
		lblNewLabel_7.setBounds(21, 248, 86, 14);
		contentPane.add(lblNewLabel_7);
		
		textFieldComissaoTotal = new JTextField();
		textFieldComissaoTotal.setBounds(116, 245, 86, 20);
		contentPane.add(textFieldComissaoTotal);
		textFieldComissaoTotal.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
		Funcionario f = new Funcionario(textFieldNome.getText(),textFieldEndereco.getText(),textFieldGenero.getText(),
				Integer.parseInt(textFieldIdade.getText()),textFieldCodigoFuncionario.getText(),Double.parseDouble(textFieldSalario.getText()),
				Integer.parseInt(textFieldNumeroVendas.getText()),Double.parseDouble(textFieldComissaoTotal.getText()));
		
		try {
			String sql = "insert into projotafuncionario (NOME,ENDERECO,GENERO,IDADE,CODIGO_FUNCIONARIO,SALARIO,NUMERO_VENDAS,COMISSAO_TOTAL) values (?,?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, f.nome);
			pst.setString(2, f.endereco);
			pst.setString(3, f.genero);
			pst.setInt(4, f.idade);
			pst.setString(5, f.codigoFuncionario);
			pst.setDouble(6, f.salario);
			pst.setInt(7,  f.numeroVendas);
			pst.setDouble(8, f.comissaoTotal);
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso");				
			
		} catch (SQLException e1) {
		    e1.printStackTrace();
		}
			}
		});
		btnSalvar.setBounds(18, 356, 89, 23);
		contentPane.add(btnSalvar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Funcionario f = new Funcionario("","","",0,textFieldCodigoFuncionario.getText(),0,0,0);
			try {
				pst = con.prepareStatement("Select * from projotafuncionario where codigo_funcionario=?");
				pst.setString(1, f.codigoFuncionario);
				rs = pst.executeQuery();
				while (rs.next()) {
					f.nome = rs.getString("nome");
					f.endereco = rs.getString("endereco");
					f.genero = rs.getString("genero");
					f.idade = rs.getInt("idade");
					f.codigoFuncionario = textFieldCodigoFuncionario.getText();
					f.salario = rs.getDouble("salario");
					f.numeroVendas = rs.getInt("numeroVendas");
					f.comissaoTotal = rs.getDouble("comissaoTotal");

				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			
			textFieldNome.setText(f.nome);
			textFieldEndereco.setText(f.endereco);
			textFieldGenero.setText(f.genero);
			textFieldIdade.setText(Integer.toString(f.idade));
			textFieldCodigoFuncionario.setText(f.codigoFuncionario);
			textFieldSalario.setText(Double.toString(f.salario));
			textFieldNumeroVendas.setText(Integer.toString(f.numeroVendas));
			textFieldComissaoTotal.setText(Double.toString(f.comissaoTotal));
			}
			
			}
		});
		btnConsultar.setBounds(117, 356, 89, 23);
		contentPane.add(btnConsultar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario f = new Funcionario(textFieldNome.getText(),textFieldEndereco.getText(),textFieldGenero.getText(),
						Integer.parseInt(textFieldIdade.getText()),textFieldCodigoFuncionario.getText(),Double.parseDouble(textFieldSalario.getText()),
						Integer.parseInt(textFieldNumeroVendas.getText()),Double.parseDouble(textFieldComissaoTotal.getText()));
				
				textFieldNome.setText("");
				textFieldEndereco.setText("");
				textFieldGenero.setText("");
				textFieldIdade.setText("");
				textFieldCodigoFuncionario.setText("");
				textFieldSalario.setText("");
				textFieldNumeroVendas.setText("");
				textFieldComissaoTotal.setText("");
				
			}
		});
		btnLimpar.setBounds(228, 356, 89, 23);
		contentPane.add(btnLimpar);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnFechar.setBounds(327, 356, 89, 23);
		contentPane.add(btnFechar);
	}
}
