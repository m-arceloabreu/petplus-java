package com.tcc.petPlusBackEnd.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="tb_agenda")
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAgenda;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario  = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JoinColumn(name="idClient", nullable=false)
	private Cliente clienteAgenda;
	
	@ManyToOne
	@JoinColumn(name="idVeterinario", nullable=false)
	private Veterinario veterinarioAgenda;
	
	/*
	 * @ManyToOne private Servico servico;
	 */

	public long getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(long idAgenda) {
		this.idAgenda = idAgenda;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Cliente getClienteAgenda() {
		return clienteAgenda;
	}

	public void setClienteAgenda(Cliente clienteAgenda) {
		this.clienteAgenda = clienteAgenda;
	}

	public Veterinario getVeterinarioAgenda() {
		return veterinarioAgenda;
	}

	public void setVeterinarioAgenda(Veterinario veterinarioAgenda) {
		this.veterinarioAgenda = veterinarioAgenda;
	}
	
	
	
}
