package projetocalcado;

public class Calcado {
	
	protected String codigo;
	protected String fabricante;
	protected String modelo;
	protected double preco;
	protected int tamanho;
	protected String cor;
	
	public Calcado(String codigo, String fabricante, String modelo, double preco,
			int tamanho, String cor) {
		
		this.codigo = codigo;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.preco = preco;
		this.tamanho = tamanho;
		this.cor = cor;
		
		
		
	}
			//public String precoProduto() {
				//return this.preco;
			
				
			//}
			
			public void mostrarDadosResumo() {
		
			System.out.println("Fabricante: " + this.fabricante);
			System.out.println("Modelo: " + this.modelo);
			System.out.println("Preço: " +this.preco);
									
			}
			public void mostrarDados() {
			
			System.out.println("Codigo: " + codigo);
			System.out.println("Fabricante: " + fabricante);
			System.out.println("Modelo: " + modelo );
			System.out.println("Preco: " + preco );
			System.out.println("Tamanho: " + tamanho );
			System.out.println("Cor: " + cor );
				
			}
			
			
}


