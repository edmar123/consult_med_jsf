/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import br.com.consultemed.models.Consulta;
import br.com.consultemed.models.Funcionario;
import br.com.consultemed.repository.repositories.ConsultaRepository;
import br.com.consultemed.repository.repositories.FuncionarioRepository;
import br.com.consultemed.repository.repositories.GenericRepository;

/**
 * 
 *
 */
public class ConsultaService extends ServicoGenerico<Consulta, Long>{
	
	@Inject
	private ConsultaRepository consultaRepository;

	public ConsultaService() {
		super(Consulta.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public GenericRepository<Consulta, Long> getRepository() {
		return this.consultaRepository;
	}
}
