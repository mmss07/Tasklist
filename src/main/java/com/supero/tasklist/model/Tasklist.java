package com.supero.tasklist.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tasklist {
	
	@Id
	@GeneratedValue	
	private Long idtasklist;	
	
	private String titulo;
	private String status;
	private Date datacadastro;
	private Date dataalteracao;
	private Date dataexclusao;
}
