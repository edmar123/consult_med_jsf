/**
 * 
 */
package br.com.consultemed.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.consultemed.models.Paciente;
import br.com.consultemed.models.enumerators.TipoUsuario;
import br.com.consultemed.services.PacienteService;
import br.com.consultemed.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Named
@RequestScoped
public class PacienteController {

	@Getter
	@Setter
	private List<Paciente> Pacientes;

	@Inject
	@Getter
	@Setter
	private Paciente Paciente;
	
	@Getter
	@Setter
	private Paciente PacienteEditar;

	@Inject
	private PacienteService service;

	@Inject
	private UsuarioService usuarioService;

	public String editar() {
		this.Paciente = this.PacienteEditar;
		return "/pages/pacientes/addPacientes.xhtml";
	}

	public String excluir() throws Exception {
		this.Paciente = this.PacienteEditar;
		this.service.remover(this.Paciente.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/pacientes/pacientes.xhtml?faces-redirect=true";
	}

	public String novoPaciente() {
		this.Paciente = new Paciente();
		return "/pages/pacientes/addPacientes.xhtml?faces-redirect=true";
	}

	public String addPaciente() {
		Paciente pacienteAsalvar = this.Paciente;

		Paciente pacienteSalvo= this.service.salvarPaciente(pacienteAsalvar);

		if (pacienteSalvo == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "login", "Já existe um login cadastrado"));
			return "";
		}
		
		return "/pages/pacientes/pacientes.xhtml?faces-redirect=true";
	}

	public List<Paciente> listaPacientes() {
		this.Pacientes = this.service.listar();
		return Pacientes;
	}
}
