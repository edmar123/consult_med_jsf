/**
 * 
 */
package br.com.consultemed.repository.repositories;

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
	
	public boolean verificarExistenciaLogin(String login) {
		TypedQuery<Boolean> query = this.manager.createQuery("select case when (count(u.id) > 0)"
				+ " then true else false end from Usuario u where u.login= :login", Boolean.class)
				.setParameter("login", login);
		return query.getSingleResult();
	}

}
