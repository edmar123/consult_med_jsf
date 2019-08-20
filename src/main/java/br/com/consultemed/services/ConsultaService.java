/**
 * 
 */
package br.com.consultemed.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.inject.Inject;

import br.com.consultemed.models.Consulta;
import br.com.consultemed.repository.repositories.ConsultaRepository;
import br.com.consultemed.repository.repositories.GenericRepository;

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
	
	public boolean existeConsultaComData(LocalDate dataAgendamento, LocalTime horaAgendamento, String nomeMedico) {
		boolean existeConsulta = this.consultaRepository.existeConsultaComData(dataAgendamento, horaAgendamento,nomeMedico);
		return existeConsulta;
	}
	
	public List<Consulta> buscarPorDataAgendamento(final LocalDate dataAgemdamento){
		return this.consultaRepository.buscarPorDataAgendamento(dataAgemdamento);
	}
}
