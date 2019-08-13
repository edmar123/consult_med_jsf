/**
 * 
 */
package br.com.consultemed.repository.repositories;

import br.com.consultemed.models.Funcionario;

public class FuncionarioRepository extends GenericRepository<Funcionario, Long>  {
	
	public FuncionarioRepository() {
		super(Funcionario.class);
		// TODO Auto-generated constructor stub
	}
}
