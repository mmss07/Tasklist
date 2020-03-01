package com.supero.tasklist.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import com.supero.tasklist.model.Tasklist;
import com.supero.tasklist.repository.Tasklists;
import com.supero.tasklist.util.jsf.FacesUtil;

public class CadastroTasklistService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Tasklists tasklists;
	

	public void Salvar(Tasklist tasklist) throws Exception{
		Tasklist tasklistExistente = tasklists.porDescricao(tasklist.getDescricao());		
		if (tasklistExistente != null && !tasklistExistente.equals(tasklist)) {			
			FacesUtil.addInfoMessage("Já existe uma tarefa com a descrição informada.");
		}else{			
			tasklists.salvar(tasklist);
		}

	}
		
	public List<Tasklist> excluir(Tasklist tasklistselecionado, List<Tasklist> tasklistsFiltrados) {		
		tasklists.excluir(tasklistselecionado);
		tasklistsFiltrados.remove(tasklistselecionado);		
		FacesUtil.addInfoMessage("Tarefa " + tasklistselecionado.getDescricao() + " excluída com sucesso.");
		return tasklistsFiltrados;
	}	
	
	public Tasklist porDescricao(String descricao) {
		Tasklist tasklist = null;
		
		try {
			tasklist = tasklists.porDescricao(descricao);
		} catch (NoResultException e) {
			
		}
		
		return tasklist;
	}
	
	public Tasklist porTitulo(String titulo) {
		Tasklist tasklist = null;
		
		try {
			tasklist = tasklists.porTitulo(titulo);
		} catch (NoResultException e) {
			
		}
		
		return tasklist;
	}

	
	
}
