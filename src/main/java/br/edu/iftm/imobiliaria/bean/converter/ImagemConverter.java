package br.edu.iftm.imobiliaria.bean.converter;

import br.edu.iftm.imobiliaria.entity.Imagem;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(value = "imagemConverter", forClass = Imagem.class)
public class ImagemConverter implements Converter<Imagem>{

    @Override
    public Imagem getAsObject(FacesContext fc, UIComponent uic, String id) {
        return (Imagem) uic.getAttributes().get("imagem_"+id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Imagem imagem) {
        if(imagem != null && imagem.getId() != null){
            uic.getAttributes().put("imagem_"+imagem.getId(), imagem);
            return imagem.getId().toString();
        }
        return "";
    }
    
}
