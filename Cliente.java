package projetocalcado;

public class Cliente extends Pessoa {

	protected String codigoCliente;
	protected double totalGasto;
	protected int numeroCompras;
	protected double mediaGastos;
	protected boolean emAtraso = false;

	public Cliente(String nome, String endereco, String genero, int idade, String codigoCliente, double totalGasto,
			int numeroCompras, double mediaGastos, boolean emAtraso) {

		super(nome, endereco, genero, idade);
		this.codigoCliente = codigoCliente;
		this.emAtraso = emAtraso;
		
		
		this.codigoCliente = codigoCliente;
		this.totalGasto = totalGasto;
		this.numeroCompras = numeroCompras;
		this.mediaGastos = mediaGastos;
		this.emAtraso = emAtraso;

	}
	
	//public void comprar(double, int)
	public void comprar(double valorItem, int qtdItem) {
	double totalGastoAtual = valorItem * qtdItem;
	
	this.totalGasto += totalGastoAtual;
	
	this.numeroCompras +=1;
	
	double gastoMedio = this.totalGasto / this.numeroCompras;
	
	this.mediaGastos = gastoMedio;	
	}
		
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Codigo Cliente: " + codigoCliente);
		System.out.println("Total Gasto: " + totalGasto);
		System.out.println("Numero Compras " + numeroCompras);
		System.out.println("Media Gastos " + mediaGastos);
		System.out.println("Em Atraso: " + emAtraso);
	}
}
