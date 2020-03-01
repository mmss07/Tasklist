package com.supero.tasklist.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.supero.tasklist.filter.TasklistFilter;
import com.supero.tasklist.model.Tasklist;
import com.supero.tasklist.model.Usuario;
import com.supero.tasklist.repository.Tasklists;
import com.supero.tasklist.service.CadastroTasklistService;
import com.supero.tasklist.util.jsf.FacesUtil;




@Named
@ViewScoped
public class PesquisaTasklistBean implements Serializable{
	

	@Inject
	private Tasklists tasklists;
	
	@Inject
	private CadastroTasklistService cadastroTasklistService;

	private static final long serialVersionUID = 1L;
	private List<Tasklist> tasklistsFiltrados;
	private Tasklist tasklistselecionado;
	private TasklistFilter filtro;
	
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			
			filtro = new TasklistFilter();
			pesquisaTasklists();
		}
		
	}
	
	public void validaSessao() {
		try {
			ExternalContext currentExternalContext = FacesContext.getCurrentInstance().getExternalContext();
			Usuario usuario = (Usuario) currentExternalContext.getSessionMap().get("usuario");
			if(usuario == null) {
				FacesUtil.addInfoMessage("Efetue login!");
				FacesContext.getCurrentInstance().getExternalContext().redirect("../Login.xhtml");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Tasklist> pesquisa() {				
		tasklistsFiltrados.clear();
		if(filtro.getStatus().equalsIgnoreCase("false")) {
			filtro.setStatus("");
		}
		tasklistsFiltrados = tasklists.filtrados(filtro);
		return tasklistsFiltrados;
	}
	public List<Tasklist> pesquisaTasklists() {
		tasklistsFiltrados = tasklists.listaTasklists();
		return tasklistsFiltrados;
	}

	public List<Tasklist> getTasklistsFiltrados() {
		return tasklistsFiltrados;
	}

	public TasklistFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(TasklistFilter filtro) {
		this.filtro = filtro;
	}
	public Tasklist getTasklistselecionado() {
		return tasklistselecionado;
	}
	public void setTasklistselecionado(Tasklist tasklistselecionado) {
		this.tasklistselecionado = tasklistselecionado;
	}
	public void setTasklistsFiltrados(List<Tasklist> tasklistsFiltrados) {
		this.tasklistsFiltrados = tasklistsFiltrados;
	}
	public void excluir() {
		tasklistselecionado.setDataexclusao(new Date());
		tasklistsFiltrados = cadastroTasklistService.excluir(tasklistselecionado, tasklistsFiltrados);							
		FacesUtil.addInfoMessage("Tarefa " + tasklistselecionado.getDescricao() + " excluída com sucesso.");
	}
	
	
	
}