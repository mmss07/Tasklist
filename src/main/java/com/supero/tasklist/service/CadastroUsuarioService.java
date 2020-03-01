package com.supero.tasklist.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.transaction.annotation.Transactional;

import com.supero.tasklist.model.Usuario;
import com.supero.tasklist.repository.Usuarios;
import com.supero.tasklist.util.jsf.FacesUtil;

public class CadastroUsuarioService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public void Salvar(Usuario usuario) throws Exception{
	
			usuarios.salvar(usuario);
		

	}
		
	
	public List<Usuario> excluir(Usuario usuarioselecionado, List<Usuario> usuariosFiltrados) {		
		usuarios.excluir(usuarioselecionado);
		usuariosFiltrados.remove(usuarioselecionado);		
		FacesUtil.addInfoMessage("Usuário " + usuarioselecionado.getNome() + " excluído com sucesso.");
		return usuariosFiltrados;
	}	
	
	public Usuario porEmail(String email) {				
		return usuarios.porEmail(email);
	}

	public Usuario porLoginESenha(String login, String senha) {
		return usuarios.porLoginESenha(login, senha);
	}
	
}
