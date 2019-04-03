package models;

public class Recebedor {
	private String nome;
	private int id;
	private String descricao;
	private String endereco;
	
	
	public Recebedor(String nome, int id, String descricao, String endereco) {
		super();
		this.nome = nome;
		this.id = id;
		this.descricao = descricao;
		this.endereco = endereco;
	}
	public String getNome() {
		return nome;
	}
	public int getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public String getEndereco() {
		return endereco;
	}
}
