package com.supero.tasklist.controller;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.supero.tasklist.model.Tasklist;
import com.supero.tasklist.model.Usuario;
import com.supero.tasklist.service.CadastroTasklistService;
import com.supero.tasklist.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroTasklistBean implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Inject 
	private CadastroTasklistService cadastroTasklistService;
	
	private Tasklist tasklist;
		
	public CadastroTasklistBean(){
		limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
					
					if(tasklist == null)
						tasklist = new Tasklist();
					System.out.println("Inicializou!");	
		}		
	}
	
	public void salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException{		
		try {
			
			
			Tasklist tasklistExistente = cadastroTasklistService.porTitulo(tasklist.getTitulo());		
			if (tasklistExistente != null && !tasklistExistente.equals(tasklist)) {			
				FacesUtil.addInfoMessage("Já existe uma tarefa com o título informado.");
			}else{	
				if(tasklist.getIdtasklist() == null) {
					tasklist.setDatacadastro(new Date());
				}else {
					tasklist.setDataalteracao(new Date());
				}
				cadastroTasklistService.Salvar(tasklist);
				limpar();
				FacesUtil.addInfoMessage("Tarefa salva com sucesso!");
			}		
			
		
		}catch (Exception e) {
			FacesUtil.addErrorMessage("ERRO ao Salvar a tarefa!");
		}					
	}
	
	public Tasklist getTasklist() {
		return tasklist;
	}
	
	public void setTasklist(Tasklist tasklist) {
		this.tasklist = tasklist;
	}

	
	private void limpar(){
		tasklist = new Tasklist();
	
	}

		
	public boolean isEditando(){
		return this.tasklist.getIdtasklist() != null;
		
	}
		

}

