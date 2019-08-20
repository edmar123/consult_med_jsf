/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Paciente;
import br.com.consultemed.models.Usuario;
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

	
	public Paciente salvarPaciente(Paciente paciente) {
		Usuario usuario = this.preparadorPersistencia.prepararParaPersistir(paciente.getPessoa().getUsuario());

		if (usuario == null) {
			return null;
		}
		paciente.getPessoa().setUsuario(usuario);

		if (paciente.getId() != null) {
			this.pacienteRepository.editar(paciente);
		} else {
			this.pacienteRepository.salvar(paciente);
		}

		return paciente;
	}

	@Override
	protected GenericRepository<Paciente, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.pacienteRepository;
	}

}
