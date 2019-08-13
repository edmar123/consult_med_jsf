package br.com.consultemed.repository.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GenericRepository<T, G> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Class<T> clazz;

	@Inject
	protected EntityManager manager;

	public GenericRepository(Class clazz) {
		this.clazz = clazz;
	}

	public List<T> listar() {
		Query query = this.manager.createQuery(" FROM " + this.clazz.getSimpleName(), this.clazz);
		List<T> entidades = query.getResultList();

		return entidades;
	}

	public void salvar(T entidade) {
		this.manager.getTransaction().begin();
		this.manager.persist(entidade);
		this.manager.getTransaction().commit();
	}

	public void remover(G id) {
		this.manager.getTransaction().begin();
		T entity = this.manager.find(this.clazz, id);
		this.manager.remove(entity);
		this.manager.getTransaction().commit();
	}

	public void editar(T entidade) {
		this.manager.getTransaction().begin();
		this.manager.merge(entidade);
		this.manager.getTransaction().commit();
	}

	public T buscarPorId(G id) {
		T entidadeRemover = this.manager.find(this.clazz, id);
		return entidadeRemover;
	}

}
