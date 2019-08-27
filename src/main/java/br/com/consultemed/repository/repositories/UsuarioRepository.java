/**
 * 
 */
package br.com.consultemed.repository.repositories;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.consultemed.models.Usuario;

/**
 * Classe responsável por gerar consultas a base de dados
 * @author edmar
 *
 */
public class UsuarioRepository extends GenericRepository<Usuario, Long> {

	public UsuarioRepository() {
		super(Usuario.class);
	}
	
	public boolean verificarExistenciaLogin(String login, String loginAntigo) {
		TypedQuery<Boolean> query = this.manager.createQuery("select case when (count(u.id) > 0)"
				+ " then true else false end from Usuario u where u.login= :login"
				+ " And u.login != :loginAntigo", Boolean.class)
				.setParameter("login", login)
				.setParameter("loginAntigo", loginAntigo);
				
		return query.getSingleResult();
	}
	
	public Usuario logarNoSistma(final String login, final String senha) {
		Usuario usuario = null;
		
		try {
			
			Query query = this.manager.createQuery("SELECT u FROM Usuario u WHERE u.login "
					+ " = :login AND u.senha = :senha");
					
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			usuario = (Usuario) query.getSingleResult();
			
			return usuario;
					
		} catch (Exception e) {
			e.getMessage();
			this.manager.getTransaction().rollback();
			
		}
		
		return usuario;
	}

}
