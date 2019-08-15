package br.com.consultemed.models;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.inject.Inject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Embeddable
@EqualsAndHashCode
@Data
public class Pessoa implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String nome;
	@Column
	private String telefone;
	
	@Inject
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_usuario") 
	private Usuario usuario;
	
}
