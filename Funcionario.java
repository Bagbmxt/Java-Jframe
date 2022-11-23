package projetocalcado;

public class Funcionario extends Pessoa {
	protected String codigoFuncionario;
	protected double salario;
	protected int numeroVendas;
	protected double comissaoTotal; 
	
	public Funcionario(String nome, String endereco, 
			String genero, int idade, String codigoFuncionario,
		double salario, int numeroVendas, double comissaoTotal) {
		
		super(nome, endereco, genero, idade);
			
			this.codigoFuncionario = codigoFuncionario;
			this.salario = salario;
			this.numeroVendas = numeroVendas;
			this.comissaoTotal = comissaoTotal;
			
		}
	
	//public void vender(double, int) 
	public void vender(double numVendas, int comissaoTotal) {
		double totalVendidoAtual = numVendas * comissaoTotal;
		
		this.numeroVendas += totalVendidoAtual;
		
		this.numeroVendas +=1;
		
		double vendaMedia = this.numeroVendas / totalVendidoAtual;
		
		this.comissaoTotal = comissaoTotal;
	}
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Codigo Funcionario: " + codigoFuncionario);
		System.out.println("Salário " + salario);
		System.out.println("Número Vendas: " +numeroVendas);
		System.out.println("Comissão Total: " + comissaoTotal);
	}

}


