package models;

import java.sql.Date;

public class Usuario {
	private String nome;
	private String sobrenome;
	private Date dataNasc;
	private String email;
	private int id;
	private String senha;
	
	
	
	public Usuario(String nome, String sobrenome, Date dataNasc, String email, int id, String senha) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNasc = dataNasc;
		this.email = email;
		this.id = id;
		this.senha = senha;
	}
	
	public boolean verificaSenha(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		}
		
		return false;
	}
	
	public boolean temSenha() {
		if(this.senha != null) {
			return true;
		}
		return false;
	}
	
	public String getNome() {
		return nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public Date getDataNasc() {
		return dataNasc;
	}
	public int getId() {
		return id;
	}
	public String getSenha() {
		return senha;
	}
}
