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

import com.supero.tasklist.model.Usuario;
import com.supero.tasklist.service.CadastroUsuarioService;
import com.supero.tasklist.util.jsf.FacesUtil;


@Named
@ViewScoped
public class CadastroUsuarioBean implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	
	@Inject 
	private CadastroUsuarioService cadastroUsuarioService;
	
	private Usuario usuario;
		
	public CadastroUsuarioBean(){
		limpar();
	}
	
	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
					
					if(usuario == null)
						usuario = new Usuario();
					System.out.println("Inicializou!");	
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
	
	public void salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException{		
		try {
			
			Usuario usuarioExistente = cadastroUsuarioService.porEmail(usuario.getEmail());		
			if (usuarioExistente != null && !usuarioExistente.equals(usuario)) {			
				FacesUtil.addInfoMessage("Já existe um usuário com o E-mail informado.");
			}else{
				//Sha2 sha2 = new Sha2(); 
				//usuario.setSenha(sha2.criptografiaSha2(usuario.getSenha()));				
				cadastroUsuarioService.Salvar(usuario);
				limpar();
				FacesUtil.addInfoMessage("Usuário Salvo com sucesso!");
			}
			
		}catch (Exception e) {
			FacesUtil.addErrorMessage("ERRO ao Salvar o usuário!");
		}		
		
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private void limpar(){
		usuario = new Usuario();
	
	}
		
	public boolean isEditando(){
		return this.usuario.getId() != null;
		
	}
		
}

