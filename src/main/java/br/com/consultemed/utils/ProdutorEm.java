package br.com.consultemed.utils;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * Classe responsável por criar uma fábrica de EntityManager
 * @author edmar
 *
 */
public class ProdutorEm implements Serializable {

	private static final long serialVersionUID = 1L;

	private  EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constantes.PERSISTENCE_UNIT_NAME);

	@Produces
	@RequestScoped
	public EntityManager createEntityManager() { 

		EntityManager em = emf.createEntityManager();

		return em;
	}

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}
}
