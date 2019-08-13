/**
 * 
 */
package br.com.consultemed.services;

import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Medico;
import br.com.consultemed.repository.repositories.GenericRepository;
import br.com.consultemed.repository.repositories.MedicoRepository;

/**
 * @author carlosbarbosagomesfilho
 *
 */
public class MedicoService extends ServicoGenerico<Medico, Long> {
	
	@Inject
	private MedicoRepository medicoRepository;
	

	public MedicoService() {
		super(Medico.class);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected GenericRepository<Medico, Long> getRepository() {
		// TODO Auto-generated method stub
		return this.medicoRepository;
	}

	
}
