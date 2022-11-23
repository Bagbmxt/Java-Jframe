package projetocalcado;

public class Sapato extends Calcado {
	
	protected String material;
	protected String estilo;
	protected String genero;
	protected int salto;
	
	public Sapato(String codigo, String fabricante, String modelo, double preco,
			int tamanho, String cor, String material, String estilo, String genero, int salto) {
		
		super(codigo, fabricante, modelo, preco, tamanho, cor);
		
		this.material = material;
		this.estilo = estilo;
		this.genero = genero;
		this.salto = salto;
		
		
	}
	
	public void mostrarDados() {
		super.mostrarDados();
		System.out.println("Material: " + material);
		System.out.println("Estilo: " + estilo);
		System.out.println("Genero: " + genero);
		System.out.println("Salto: " + salto);
	}
		
}

