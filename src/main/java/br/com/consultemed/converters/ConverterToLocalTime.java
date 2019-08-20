package br.com.consultemed.converters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalTime.class, value="localTimeConverter")
public class ConverterToLocalTime implements Serializable, Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Locale BRAZIL = new Locale("pt", "BR");
		return LocalTime.parse(value, DateTimeFormatter.ofPattern("HH:mm").withLocale(BRAZIL));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalTime dateValue = (LocalTime) value;

		return dateValue.format(DateTimeFormatter.ofPattern("HH:mm"));  

	}

}
