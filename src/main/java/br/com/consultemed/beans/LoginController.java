/**
 * 
 */
package br.com.consultemed.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import br.com.consultemed.models.Usuario;
import br.com.consultemed.services.UsuarioService;
import lombok.Getter;
import lombok.Setter;

/**
 * @author edmar soares
 *
 */

@Named
@RequestScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@Inject
	private Usuario usuario;

	@Getter
	@Setter
	@Inject
	private UsuarioService usuarioService;
	
	@Inject
	@Getter
	@Setter
	private HttpSession session;

//	public String loginUsuario() {
//		// this.usuarioLogado.logar();
//		return "home?faces-redirect=true";
//	}

	public String logout() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuarioAutenticado", null);
		return "login.xhtml?faces-redirect=true";
	}

	public String logar() {

		Usuario usuarioAutenticado = usuarioService.logar(usuario.getLogin(), usuario.getSenha());
		if (usuarioAutenticado == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "login", "Este usuário não existe no sistema"));
			return "";
		} else {
			FacesContext ctx = FacesContext.getCurrentInstance();
			session = (HttpSession) ctx.getExternalContext().getSession(false);
			session.setAttribute("usuarioAutenticado", usuarioAutenticado);
			System.out.println(session.getId());
		}

		return "/home.xhtml";
	}

	// Fase 1: Restore View (Restauração da visão);
	// Fase 2: Apply Request Values (Aplicar valores da requisição);
	// Fase 3: Process Validation (Processar as validações);
	// Fase 4: Update Model Values (Atualizar valores de modelo);
	// Fase 5: Invoke Application (Invocar aplicação);
	// Fase 6: Render Response (Renderizar a resposta).

}
