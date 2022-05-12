package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.logic.ImagemLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ImagemBean extends CrudBean<Imagem, ImagemLogic>{
    
    @Inject
    private ImagemLogic logic;

    public ImagemBean() {
        super(Imagem.class);
    }
    
    
    
    @Override
    public ImagemLogic getLogic() {
        return this.logic;
    }
    
}
