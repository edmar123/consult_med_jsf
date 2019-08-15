/**
 * 
 */
package br.com.consultemed.repository.repositories;

import java.time.LocalDate;

import javax.persistence.Query;

import br.com.consultemed.models.Consulta;

public class ConsultaRepository extends GenericRepository<Consulta, Long> {

	public ConsultaRepository() {
		super(Consulta.class);
		// TODO Auto-generated constructor stub
	}
	
	public boolean existeConsultaComData(LocalDate dataAgendamento) {
		Query query = this.manager.createQuery("select case when (count(con) > 0) then true else false end "
				+ "from Consulta con INNER JOIN con.agendamento as agen"
				+ " where agen.dataAgendamento = :dataAgendamento");
		query.setParameter("dataAgendamento", dataAgendamento);
		
		boolean existe = (boolean) query.getSingleResult();
		return existe;
	}
}
