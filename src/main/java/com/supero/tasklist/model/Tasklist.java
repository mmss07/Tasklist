package com.supero.tasklist.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tasklist {
	
	@Id
	@GeneratedValue	
	private Long idtasklist;	
	
	private String descricao;
	
	@NotNull
	private String titulo;
		
	private String status;
	private Date datacadastro;
	private Date dataalteracao;
	private Date dataexclusao;
	public Long getIdtasklist() {
		return idtasklist;
	}
	public void setIdtasklist(Long idtasklist) {
		this.idtasklist = idtasklist;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDatacadastro() {
		return datacadastro;
	}
	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}
	public Date getDataalteracao() {
		return dataalteracao;
	}
	public void setDataalteracao(Date dataalteracao) {
		this.dataalteracao = dataalteracao;
	}
	public Date getDataexclusao() {
		return dataexclusao;
	}
	public void setDataexclusao(Date dataexclusao) {
		this.dataexclusao = dataexclusao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtasklist == null) ? 0 : idtasklist.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tasklist other = (Tasklist) obj;
		if (idtasklist == null) {
			if (other.idtasklist != null)
				return false;
		} else if (!idtasklist.equals(other.idtasklist))
			return false;
		return true;
	}
	
	
	
}
