package com.tcc.petPlusBackEnd.model;

public class VeterinarioLogin {
	private long idVeterinario;
	private String nome;
	private String email;
	private String senha;
	private String imagem;
	private String token;
	
	
	public long getIdVeterinario() {
		return idVeterinario;
	}
	public void setIdVeterinario(long idVeterinario) {
		this.idVeterinario = idVeterinario;
	}
	public String getNome() {
		return nome;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	

}
