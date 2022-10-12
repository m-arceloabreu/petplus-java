package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tb_cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idClient;
	
	@NotNull
	@Size(min = 3, max= 50)
	private String nome;
	
	@NotNull
	private String cpf;
	
	@NotNull
	@Email(message = "O atributo Usuario deve ser um email válido")
	private String email;
	
	@NotNull
	@Size(min = 5)
	private String senha;
	
	@NotNull
	private String telefone;
	
	@Size(max = 5000, message = "The picture link can't be bigger than 5000 chars")
	private String picture;
	
	private String logradouro;
	
	private String bairro;
	
	private String cidade;
	
	private String uf;
	
	@OneToMany(mappedBy = "clientePet", cascade = CascadeType.ALL)
	private List<Pet> pet;
	
	@ManyToMany
	@JoinTable(
		name = "Cliente_Servico",
		joinColumns = @JoinColumn(name = "idCliente"),
		inverseJoinColumns = @JoinColumn(name = "idServico")
	)
	private List<Servico> servicoCliente;

	public List<Servico> getServicoCliente() {
		return servicoCliente;
	}

	public void setServicoCliente(List<Servico> servicoCliente) {
		this.servicoCliente = servicoCliente;
	}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}
	
	
}
