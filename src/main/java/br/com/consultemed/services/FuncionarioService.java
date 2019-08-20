/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.models.Usuario;
import br.com.consultemed.repository.repositories.FuncionarioRepository;
import br.com.consultemed.repository.repositories.GenericRepository;

/**
 * 
 *
 */
public class FuncionarioService extends ServicoGenerico<Funcionario, Long>{
	
	@Inject
	private FuncionarioRepository funcionarioRepository;

	public FuncionarioService() {
		super(Funcionario.class);
		// TODO Auto-generated constructor stub
	}
	
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		Usuario usuario = this.preparadorPersistencia.prepararParaPersistir(funcionario.getPessoa().getUsuario());
		
		if (usuario == null) {
			return null;
		}
		funcionario.getPessoa().setUsuario(usuario);
		
		if (funcionario.getId() != null) {
			this.funcionarioRepository.editar(funcionario);
		}else {
			this.funcionarioRepository.salvar(funcionario);
		}
		
		return funcionario;
	}
	
	@Override
	public GenericRepository<Funcionario, Long> getRepository() {
		return this.funcionarioRepository;
	}
}
