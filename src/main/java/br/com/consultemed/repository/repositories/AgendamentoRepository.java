/**
 * 
 */
package br.com.consultemed.repository.repositories;

import br.com.consultemed.models.Agendamento;

public class AgendamentoRepository extends GenericRepository<Agendamento, Long> {

	public AgendamentoRepository() {
		super(Agendamento.class);
	}

}
