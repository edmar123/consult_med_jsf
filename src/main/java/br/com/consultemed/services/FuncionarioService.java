/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.repository.repositories.FuncionarioRepository;
import br.com.consultemed.repository.repositories.GenericRepository;

/**
 * 
 *
 */
public class FuncionarioService extends ServicoGenerico<Funcionario, Long>{
	
	@Inject
	private FuncionarioRepository funcionarioDao;

	public FuncionarioService() {
		super(Funcionario.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public GenericRepository<Funcionario, Long> getRepository() {
		return this.funcionarioDao;
	}
}
