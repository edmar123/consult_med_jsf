package br.com.consultemed.models;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.consultemed.converters.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Data
public class Consulta implements Serializable, BaseEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String descricao;
	
	@Getter
	@Setter
	@Inject
	@OneToOne()
	@JoinColumn(name="id_medico" )
	private Medico medico;
	
	@Inject
	@OneToOne(cascade= {CascadeType.ALL}) 
	@JoinColumn(name="id_agendamento")
	private Agendamento agendamento;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="id_consulta")
//	private List<Exame> exames;
	
	
		
}
