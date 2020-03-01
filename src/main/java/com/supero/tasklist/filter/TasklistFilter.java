package com.supero.tasklist.filter;


import java.io.Serializable;



public class TasklistFilter implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private String status;
	private String titulo;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
