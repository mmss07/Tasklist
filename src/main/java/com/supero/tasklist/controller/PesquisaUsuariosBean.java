package com.supero.tasklist.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.supero.tasklist.filter.UsuarioFilter;
import com.supero.tasklist.model.Usuario;
import com.supero.tasklist.repository.Usuarios;
import com.supero.tasklist.service.CadastroUsuarioService;
import com.supero.tasklist.util.jsf.FacesUtil;




@Named
@ViewScoped
public class PesquisaUsuariosBean implements Serializable{
	
	@Inject
	private CadastroUsuarioService cadastroUsuarioService;
	
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuariosFiltrados;
	private Usuario usuarioselecionado;
	private UsuarioFilter filtro;
	
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			
			filtro = new UsuarioFilter();
			pesquisaUsuarios();
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
	public List<Usuario> pesquisa() {		
		
		usuariosFiltrados.clear();
		usuariosFiltrados = cadastroUsuarioService.filtrados(filtro);
		
		return usuariosFiltrados;
	}
	public List<Usuario> pesquisaUsuarios() {
		usuariosFiltrados = cadastroUsuarioService.listaUsuarios();
		return usuariosFiltrados;
	}

	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}

	public UsuarioFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(UsuarioFilter filtro) {
		this.filtro = filtro;
	}
	public Usuario getUsuarioselecionado() {
		return usuarioselecionado;
	}
	public void setUsuarioselecionado(Usuario usuarioselecionado) {
		this.usuarioselecionado = usuarioselecionado;
	}
	public void setUsuariosFiltrados(List<Usuario> usuariosFiltrados) {
		this.usuariosFiltrados = usuariosFiltrados;
	}
	public void excluir() {
		
		usuariosFiltrados = cadastroUsuarioService.excluir(usuarioselecionado, usuariosFiltrados);							
		FacesUtil.addInfoMessage("Usuário " + usuarioselecionado.getNome() + " excluído com sucesso.");
	}
	
	
	
}