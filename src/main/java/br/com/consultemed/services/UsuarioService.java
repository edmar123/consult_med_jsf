/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.repositories.GenericRepository;
import br.com.consultemed.repository.repositories.UsuarioRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class UsuarioService extends ServicoGenerico<Usuario, Long> {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}
	
	public boolean verificarExistenciaLogin(final String login, final String loginAntigo) {
		return this.usuarioRepository.verificarExistenciaLogin(login, loginAntigo); 
	}

	@Override
	protected GenericRepository<Usuario, Long> getRepository() {
		// TODO Auto-generated method stub
		return usuarioRepository;
	}
}
