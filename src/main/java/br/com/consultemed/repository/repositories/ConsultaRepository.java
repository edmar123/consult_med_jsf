/**
 * 
 */
package br.com.consultemed.repository.repositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Query;

import br.com.consultemed.models.Consulta;

public class ConsultaRepository extends GenericRepository<Consulta, Long> {

	public ConsultaRepository() {
		super(Consulta.class);
		// TODO Auto-generated constructor stub
	}

	public boolean existeConsultaComData(final LocalDate dataAgendamento, final LocalTime horaAgendamento, final String nomeMedico) {
		Query query = this.manager.createQuery("select case when (count(con) > 0) then true else false end "
				+ "from Consulta con INNER JOIN con.agendamento as agen"
				+ " where agen.dataAgendamento = :dataAgendamento " 
				+ " and agen.horaAgendamento = :hora"
				+ "	and con.medico.pessoa.nome = :nome");
		query.setParameter("dataAgendamento", dataAgendamento)
			 .setParameter("hora", horaAgendamento)
			 .setParameter("nome", nomeMedico);

		boolean existe = (boolean) query.getSingleResult();
		return existe;
	}

	public List<Consulta> buscarPorDataAgendamento(final LocalDate agendamento) {
		Query query = this.manager.createQuery("SELECT c FROM Consulta c INNER JOIN c.agendamento as agen WHERE"
				+ " agen.dataAgendamento = :agendamento");
		query.setParameter("agendamento", agendamento);
		List<Consulta> entidades = query.getResultList();

		return entidades;
	}
}
