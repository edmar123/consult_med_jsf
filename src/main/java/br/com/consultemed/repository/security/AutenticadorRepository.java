package br.com.consultemed.repository.security;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.consultemed.models.Usuario;

public class AutenticadorRepository {

	@Inject
	EntityManager factory;
	
	public Usuario autenticador(String login, String senha) {
		
		Usuario usuario = null;
		
		try {
			Query query = this.factory.createNamedQuery("Usuario.loginUsuario");
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			usuario = (Usuario) query.getSingleResult();
			
			return usuario;
					
		} catch (Exception e) {
			e.getMessage();
			this.factory.getTransaction().rollback();
			
		}finally {
			this.factory.close();
		}
		
		return usuario;
	}
}
