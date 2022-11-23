package projetocalcado;

public class Pedido {
	protected int numeroPedido;
	protected double valorTotal;
	protected double numeroItens;
	protected boolean pago;
	protected Funcionario vendedor;
	protected Cliente comprador;
	
	// public Pedido(int, Funcionario,	Cliente)

	public Pedido(int numeroPedido, double valorTotal, double numeroItens, boolean pago, Funcionario vendedor, Cliente comprador) {
		this.numeroPedido = numeroPedido;
		this.valorTotal = valorTotal;
		this.numeroItens = numeroItens;
		this.pago = pago;
		this.vendedor = vendedor;
		this.comprador = comprador;	
	}
	//public void inserirItem(Sapato, int) 
	public void inserirItem(Sapato numeroPedido) {
		
		this.numeroPedido+=1;
		this.numeroItens+=1;
		
		//this.valorTotal *= this.numeroItens;
		this.valorTotal *= this.numeroItens;
		this.valorTotal = valorTotal;
		this.fecharPedido();
		
		
		
		
	}
	//public void inserirItem(Tenis, int) 
	//public void inserirItem() {
	
		
	//}


	//public void fecharPedido()
	public void fecharPedido() {
		if(pago == true)
			System.out.println("Pedido Pago!!!");
		if(pago == false)
			System.out.println("Você Precisa realizar o pagamento");
		return ;
		
	}
}
