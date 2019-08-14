package br.com.consultemed.converters;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = LocalDate.class, value="localDateConverter")
public class ConverterLocalDate implements Serializable, Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Locale BRAZIL = new Locale("pt", "BR");
		return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd/MM/yy").withLocale(BRAZIL));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		LocalDate dateValue = (LocalDate) value;

		return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yy"));

	}

}
