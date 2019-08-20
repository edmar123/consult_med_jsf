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

import br.com.consultemed.models.Medico;
import br.com.consultemed.models.enumerators.TipoUsuario;
import br.com.consultemed.services.MedicoService;
import br.com.consultemed.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Named
@RequestScoped
public class MedicoController {

	@Getter
	@Setter
	private List<Medico> medicos;

	@Inject
	@Getter
	@Setter
	private Medico medico;

	@Getter
	@Setter
	private Medico medicoEditar;

	@Inject
	private MedicoService service;

	@Inject
	private UsuarioService usuarioService;

	public String editar() {
		this.medico = this.medicoEditar;
		return "/pages/medicos/addMedicos.xhtml";
	}

	public String excluir() throws Exception {
		this.medico = this.medicoEditar;
		this.service.remover(this.medico.getId());
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/medicos/medicos.xhtml?faces-redirect=true";
	}

	public String novoMedico() {
		this.medico = new Medico();
		return "/pages/medicos/addMedicos.xhtml?faces-redirect=true";
	}

	public String addMedico() {

		Medico medicoSalvo = this.service.salvarMedico(this.medico);

		if (medicoSalvo == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "login", "Já existe um login cadastrado"));
			return "";
		}
		return "/pages/medicos/medicos.xhtml?faces-redirect=true";
	}

	public List<Medico> listaMedicos() {
		this.medicos = this.service.listar();
		return medicos;
	}
}
