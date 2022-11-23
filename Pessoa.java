package projetocalcado;

public class Pessoa {
	
	protected String nome;
	protected String endereco;
	protected String genero;
	protected int idade;
	
	public Pessoa(String nome, String endereco, String genero, int idade) {
		this.nome = nome;
		this.endereco = endereco;
		this.genero = genero;
		this.idade = idade;
	}
	public void mostrarDados() {
		System.out.println("Nome: " + nome);
		System.out.println("Endereço: " + endereco);
		System.out.println("Genero: " + genero);
		System.out.println("Idade: " + idade);
	}

}
