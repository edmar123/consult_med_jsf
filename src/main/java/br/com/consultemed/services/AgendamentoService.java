/**
 * 
 */
package br.com.consultemed.services;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.com.consultemed.models.Agendamento;
import br.com.consultemed.repository.repositories.AgendamentoRepository;
import br.com.consultemed.repository.repositories.GenericRepository;

public class AgendamentoService extends ServicoGenerico<Agendamento, Long>{
	
	@Inject
	private AgendamentoRepository consultaRepository;

	public AgendamentoService() {
		super(Agendamento.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public GenericRepository<Agendamento, Long> getRepository() {
		return this.consultaRepository;
	}
	
}
