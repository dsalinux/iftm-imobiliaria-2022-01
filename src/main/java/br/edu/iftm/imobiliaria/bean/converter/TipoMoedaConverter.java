package br.edu.iftm.imobiliaria.bean.converter;

import br.edu.iftm.imobiliaria.entity.TipoMoeda;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(value = "tipoMoedaConverter", forClass = TipoMoeda.class)
public class TipoMoedaConverter implements Converter<TipoMoeda>{

    @Override
    public TipoMoeda getAsObject(FacesContext fc, UIComponent uic, String id) {
        return (TipoMoeda) uic.getAttributes().get("tipoMoeda_"+id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoMoeda tipoMoeda) {
        if(tipoMoeda != null && tipoMoeda.getId() != null){
            uic.getAttributes().put("tipoMoeda_"+tipoMoeda.getId(), tipoMoeda);
            return tipoMoeda.getId().toString();
        }
        return "";
    }
    
}
