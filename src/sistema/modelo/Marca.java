package sistema.modelo;

public class Marca {
	
	private int id;
	private String nome;
	
	public Marca(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
