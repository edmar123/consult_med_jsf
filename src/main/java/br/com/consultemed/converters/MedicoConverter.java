package br.com.consultemed.converters;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.consultemed.models.Medico;
import br.com.consultemed.utils.JPAUtils;

@FacesConverter(forClass = Medico.class, value = "medicoConverter")
public class MedicoConverter implements Serializable, Converter {
	
	EntityManagerFactory emf = JPAUtils.getEntityManagerFactory();
	EntityManager manager = emf.createEntityManager();
	
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		Medico automovel = (Medico) object;
		if (automovel == null || automovel.getId() == null)
			return null;
		return String.valueOf(automovel.getId());
	}

	public Object getAsObject(FacesContext context, UIComponent component, String string) {
		if (string == null || string.isEmpty())
			return null; 
		Long id = Long.valueOf(string);
		Medico medico = manager.find(Medico.class, id); 
		return medico;
	}

	// public Object getAsObject(FacesContext ctx, UIComponent component, String
	// value) {
	// if (value != null) {
	// return Long.valueOf(value);
	// }
	// return null;
	// }
	//
	// public String getAsString(FacesContext ctx, UIComponent component, Object
	// value) {
	//
	// if (value != null && !"".equals(value)) {
	//
	// BaseEntity entity = (BaseEntity) value;
	//
	// // adiciona item como atributo do componente
	// this.addAttribute(component, entity);
	//
	// Long codigo = entity.getId();
	// if (codigo != null) {
	// return String.valueOf(codigo);
	// }
	// }
	//
	// return (String) value;
	// }
	//
	// protected void addAttribute(UIComponent component, BaseEntity o) {
	// String key = o.getId().toString(); // codigo da empresa como chave neste caso
	// this.getAttributesFrom(component).put(key, o);
	// }
	//
	// protected Map<String, Object> getAttributesFrom(UIComponent component) {
	// return component.getAttributes();
	// }

}
