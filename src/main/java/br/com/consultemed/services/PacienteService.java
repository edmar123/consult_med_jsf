/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Paciente;
import br.com.consultemed.repository.repositories.GenericRepository;
import br.com.consultemed.repository.repositories.PacienteRepository;

/**
 * @author edmar soares de lima
 *
 */
public class PacienteService extends ServicoGenerico<Paciente, Long> {

	@Inject
	private PacienteRepository pacienteRepository;
	
	@Inject
	private UsuarioService usuarioService;
	
	public PacienteService() {
		super(Paciente.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(Paciente paciente) {
//		boolean existeLogin = this.usuarioService
//				.verificarExistenciaLogin(paciente.getPessoa().getUsuario().getLogin());
		this.getRepository().salvar(paciente);
	}

	@Override
	protected GenericRepository<Paciente, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.pacienteRepository;
	}

}
