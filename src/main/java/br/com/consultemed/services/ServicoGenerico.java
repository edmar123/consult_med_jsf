package br.com.consultemed.services;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.jboss.logging.Logger;

import br.com.consultemed.repository.repositories.GenericRepository;

public abstract  class ServicoGenerico<T, G extends Serializable> {
	
	Logger log = Logger.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private Class<T> clazz;
	
	@Inject
	protected PreparadorPersistencia preparadorPersistencia;
	
	@SuppressWarnings("unchecked")
	public ServicoGenerico(Class clazz) {
		this.clazz = clazz;
	}

	protected abstract GenericRepository<T, G> getRepository();

	public List<T> listar() {
		this.log.debug("Listando " + this.clazz);
		List<T> entidades =  this.getRepository().listar();
		return entidades;
	}

	public void salvar(T entidade) {
		this.getRepository().salvar(entidade);
	}

	public void remover(G id) {
		this.getRepository().remover(id);
	}

	public void editar(T entidade) {
		this.getRepository().editar(entidade);
	}

	public T buscarPorId(G id) {
		return this.getRepository().buscarPorId(id);
	}
}
