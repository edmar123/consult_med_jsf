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

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table
@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
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
	
	public StatusAgendamento[] getStatus() {
		return StatusAgendamento.getStatus();
	}
}
