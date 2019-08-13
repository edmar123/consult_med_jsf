package br.com.consultemed.models;

import lombok.Getter;

public enum StatusAgendamento {
	CANCELADO("Cancelado"),
	AGENDADO("Agendado"),
	REAGENDADO("Reagendamento");
	
	@Getter
	private String decricao;
	
	private StatusAgendamento(String descricao) {
		this.decricao = descricao;
	}
}
