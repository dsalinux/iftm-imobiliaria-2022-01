package br.edu.iftm.imobiliaria.bean.converter;

import br.edu.iftm.imobiliaria.entity.TipoMensagem;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(value = "tipoMensagemConverter", forClass = TipoMensagem.class)
public class TipoMensagemConverter implements Converter<TipoMensagem>{

    @Override
    public TipoMensagem getAsObject(FacesContext fc, UIComponent uic, String id) {
        return (TipoMensagem) uic.getAttributes().get("tipoMensagem_"+id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoMensagem tipoMensagem) {
        if(tipoMensagem != null && tipoMensagem.getId() != null){
            uic.getAttributes().put("tipoMensagem_"+tipoMensagem.getId(), tipoMensagem);
            return tipoMensagem.getId().toString();
        }
        return "";
    }
    
}
