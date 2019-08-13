/**
 * 
 */
package br.com.consultemed.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Agendamento;
import br.com.consultemed.models.Consulta;
import br.com.consultemed.models.Medico;
import br.com.consultemed.models.Paciente;
import br.com.consultemed.services.ConsultaService;
import br.com.consultemed.services.MedicoService;
import br.com.consultemed.services.PacienteService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author edmar
 *
 */
@Named
@RequestScoped
public class ConsultaController {

	@Getter
	@Setter
	private List<Consulta> consultas;
	
	@Getter
	@Setter
	private List<Medico> medicos;
	
	@Getter
	@Setter
	private List<Paciente> pacientes;

	@Inject
	@Getter
	@Setter
	private Consulta consulta;

	@Getter
	@Setter
	private Consulta consultaEditar;

	@Inject
	private ConsultaService service;
	
	@Inject
	private MedicoService medicoService;
	
	@Inject
	private PacienteService pacienteService;   

	@PostConstruct
	public void init() {
		if (this.medicos == null) {
			this.medicos = medicoService.listar();
		}
		if (this.pacientes == null) { 
			this.pacientes = pacienteService.listar();
		} 
	}

	public String editar() {
		this.consulta = this.consultaEditar;
		return "/pages/consultas/addConsultas.xhtml";
	}

	public String excluir() throws Exception {
		this.consulta = this.consultaEditar;
		this.service.remover(this.consulta.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Consulta excluída"));
		return "/pages/consultas/consultas.xhtml?faces-redirect=true";
	}

	public String novaConsulta() {
		this.consulta = new Consulta();
		return "/pages/consultas/addConsultas.xhtml?faces-redirect=true";
	}

	public String addConsulta() {
		Consulta funcionarioAsalvar = this.consulta;

		this.service.salvar(funcionarioAsalvar);
		return "/pages/consultas/consultas.xhtml?faces-redirect=true";
	}

	public List<Consulta> listaConsultas() {
		this.consultas = this.service.listar();
		return this.consultas;
	}
}
