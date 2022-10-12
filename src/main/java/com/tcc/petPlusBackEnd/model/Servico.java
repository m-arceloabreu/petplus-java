package com.tcc.petPlusBackEnd.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_servico")
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idServico;
	
	@NotNull
	String tipoServico;
	
	@ManyToMany(mappedBy = "servicoCliente")
	private List<Cliente> cliente;
	
	@ManyToOne
	@JoinColumn(name="idProduto", nullable=false)
	private Produto produtoServico;
	
	@ManyToMany(mappedBy = "servicoVeterinario")
	private List<Veterinario> veterinarioServico;

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public Produto getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(Produto produtoServico) {
		this.produtoServico = produtoServico;
	}

	public List<Veterinario> getVeterinarioServico() {
		return veterinarioServico;
	}

	public void setVeterinarioServico(List<Veterinario> veterinarioServico) {
		this.veterinarioServico = veterinarioServico;
	}
	
	
}
