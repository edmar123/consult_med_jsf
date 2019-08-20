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

import br.com.consultemed.models.Funcionario;
import br.com.consultemed.models.Pessoa;
import br.com.consultemed.models.Usuario;
import br.com.consultemed.models.enumerators.TipoUsuario;
import br.com.consultemed.services.FuncionarioService;
import br.com.consultemed.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author carlosbarbosagomesfilho
 *
 */
@Named
@RequestScoped
public class FuncionarioControler{
	
	@Getter
	@Setter
	private List<Funcionario> funcionarios;

	@Inject
	@Getter
	@Setter
	private Funcionario funcionario;
	
	@Inject
	@Getter
	@Setter
	private Usuario usuario;
	
	@Inject
	@Getter
	@Setter
	private Pessoa pessoa;
	
	@Getter
	@Setter
	private Funcionario funcionarioEditar;
	
	@Inject
	private FuncionarioService service;
	
	@Inject
	private UsuarioService usuarioService;
	
	
	public String editar() {
		this.funcionario = this.funcionarioEditar;
		return "/pages/funcionarios/addFuncionarios.xhtml";
	}
	
	public String excluir() throws Exception {
		this.funcionario = this.funcionarioEditar;
		this.service.remover(this.funcionario.getId());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
		return "/pages/medicos/funcionarios.xhtml?faces-redirect=true";
	}
	
	public String novoFuncionario() {
		this.funcionario = new Funcionario();
		return "/pages/funcionarios/addFuncionarios.xhtml?faces-redirect=true";
	}
	
	public String addFuncionario() {
		Funcionario funcionarioAsalvar = this.funcionario;
		
		funcionarioAsalvar.getPessoa().getUsuario().setTipoUsuario(TipoUsuario.fUNCIONARIO);

		Funcionario funcionarioSalvo = this.service.salvarFuncionario(funcionarioAsalvar);

		if (funcionarioSalvo == null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"login", "Já existe um login cadastrado"));
			return "";
		}
	
		return "/pages/funcionarios/funcionarios.xhtml?faces-redirect=true";
	}
	
	public List<Funcionario> listaFuncionarios(){
		this.funcionarios = this.service.listar();
		return this.funcionarios;
	}
}
