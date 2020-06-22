package sistema.modelo;

public class Produto {
	
	private int ean;
	private String nome;
	private double valor;
	
	public Produto(int ean, String nome, double valor) {
		this.ean = ean;
		this.nome = nome;
		this.valor = valor;
	}

	public int getEan() {
		return ean;
	}

	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}
	
}
