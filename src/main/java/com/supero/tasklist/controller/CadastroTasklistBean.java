package com.supero.tasklist.controller;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.supero.tasklist.model.Tasklist;
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
					validaSessao();
					if(tasklist == null)
						tasklist = new Tasklist();
					System.out.println("Inicializou!");	
		}		
	}

	public void validaSessao() {
		try {
			ExternalContext currentExternalContext = FacesContext.getCurrentInstance().getExternalContext();
			Tasklist tasklist = (Tasklist) currentExternalContext.getSessionMap().get("tasklist");
			if(tasklist == null) {
				FacesUtil.addInfoMessage("Efetue login!");
				FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException{		
		try {
			
			
			Tasklist tasklistExistente = cadastroTasklistService.porDescricao(tasklist.getDescricao());		
			if (tasklistExistente != null && !tasklistExistente.equals(tasklist)) {			
				FacesUtil.addInfoMessage("Já existe uma tarrefa com a descrição informada.");
			}else{			
				cadastroTasklistService.Salvar(tasklist);
			}		
			
		
		}catch (Exception e) {
			FacesUtil.addErrorMessage("ERRO ao Salvar o usuário!");
		}
			
		limpar();
		
		FacesUtil.addInfoMessage("Usuário Salvo com sucesso!");
		
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

