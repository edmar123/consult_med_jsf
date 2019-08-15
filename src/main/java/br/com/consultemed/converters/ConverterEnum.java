package br.com.consultemed.converters;

import java.io.Serializable;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

import br.com.consultemed.models.enumerators.StatusAgendamento;

@FacesConverter(value = "enumConverter")
public class ConverterEnum extends EnumConverter implements Serializable {

	public ConverterEnum() {
		super(StatusAgendamento.class);
	}
}
