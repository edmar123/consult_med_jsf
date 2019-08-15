package br.com.consultemed.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.inject.Inject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.consultemed.models.enumerators.StatusAgendamento;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
public class Agendamento implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
		
	@Column(name="data_agendamento")
	private LocalDate dataAgendamento;
	
	@Inject
	@OneToOne
	@JoinColumn(name="id_paciente")
	private Paciente paciente;
	
	@Enumerated(EnumType.STRING)
	private StatusAgendamento status;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
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
	
	
}
