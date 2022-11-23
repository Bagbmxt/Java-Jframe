package projetocalcado;

public class Tenis extends Calcado {
	
	protected String categoria;
	protected boolean amortecimento;
	protected String cor1;
	protected String cor2;
	
	public Tenis(String codigo, String fabricante, String modelo, double preco,
			int tamanho, String cor, String categoria, Boolean amortecimento, String cor1, String cor2 ) {
	
	super(codigo, fabricante, modelo, preco, tamanho, cor);
			
	
	this.categoria = categoria;
	this.amortecimento = amortecimento;
	this.cor1 = cor1;
	this.cor2 = cor2;
	
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Categoria: " + categoria);
		System.out.println("Amortecimento: " + amortecimento);
		System.out.println("Cor1: " + cor1);
		System.out.println("Cor2 " + cor2);
	}
}
