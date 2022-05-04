package br.edu.iftm.imobiliaria.bean.converter;

import br.edu.iftm.imobiliaria.entity.Permissao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(value = "permissaoConverter", forClass = Permissao.class)
public class PermissaoConverter implements Converter<Permissao>{

    @Override
    public Permissao getAsObject(FacesContext fc, UIComponent uic, String id) {
        return (Permissao) uic.getAttributes().get("permissao_"+id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Permissao permissao) {
        if(permissao != null && permissao.getId() != null){
            uic.getAttributes().put("permissao_"+permissao.getId(), permissao);
            return permissao.getId().toString();
        }
        return "";
    }
    
}
