package com.supero.tasklist.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.supero.tasklist.model.Tasklist;
import com.supero.tasklist.repository.Tasklists;
import com.supero.tasklist.util.cdi.CDIServiceLocator;



@FacesConverter(forClass = Tasklist.class)
public class TasklistConverter implements Converter {
	
		private Tasklists tasklists;
		
		public TasklistConverter() {
			tasklists = CDIServiceLocator.getBean(Tasklists.class);
		}
		
		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Tasklist retorno = null;
			
			if (value != null) {
				Long id = new Long(value);
				retorno = tasklists.porId(id);
			}
			
			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				Tasklist tasklist = (Tasklist) value;
				return tasklist.getIdtasklist() == null ? null : tasklist.getIdtasklist().toString();
			}
			
			return "";
		}

}
