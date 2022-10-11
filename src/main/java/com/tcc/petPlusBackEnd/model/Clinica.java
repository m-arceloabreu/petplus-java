package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tb_clinica")
public class Clinica {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClinica;
	
	@NotNull
	private String nome;
	
	@NotNull
	@Email(message = "O atributo Usuario deve ser um email válido")
	private String email;
	
	@NotNull
	@Size(min = 5)
	private String senha;
	
	@NotNull
	private String telefone;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@NotNull
	private String bairro;
	
	@NotNull
	private String cidade;
	
	@NotNull
	private String uf;
	
	
	@ManyToMany(mappedBy = "clinicaVeterinario") 
	private List<Veterinario> veterinario;
	  
	/*
	 * @ManyToMany(mappedBy = "clinicaFuncionario") private List<Funcionario>
	 * funcionario;
	 */
	 

	public Long getIdClinica() {
		return idClinica;
	}

	public void setIdClinica(Long idClinica) {
		this.idClinica = idClinica;
	}

	public String getNome() {
		return nome;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
