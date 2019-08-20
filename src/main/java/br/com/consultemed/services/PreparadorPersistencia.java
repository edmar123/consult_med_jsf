package br.com.consultemed.services;

import java.io.Serializable;

import javax.inject.Inject;

import org.primefaces.util.BeanUtils;

import antlr.StringUtils;
import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.repositories.UsuarioRepository;

public class PreparadorPersistencia implements Serializable {
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	public Usuario prepararParaPersistir(final Usuario usuario) {

		String loginAntigo = "";
		
		if (usuario.getId() != null) {
			
			final Usuario usuarioDB  = this.usuarioRepository.buscarPorId(usuario.getId());

			loginAntigo = usuarioDB.getLogin();
		}
		
		final boolean existeLogin = this.usuarioRepository.verificarExistenciaLogin(usuario.getLogin(), loginAntigo);
		
		if (existeLogin) {
			return null;
		}
		
		return usuario;
	}
	
}
