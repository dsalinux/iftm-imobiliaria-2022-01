package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.TipoMoeda;
import br.edu.iftm.imobiliaria.logic.TipoMoedaLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class TipoMoedaBean extends CrudBean<TipoMoeda, TipoMoedaLogic> {

    @Inject
    private TipoMoedaLogic logic;
    
    public TipoMoedaBean() {
        super(TipoMoeda.class);
    }

    @Override
    public TipoMoedaLogic getLogic() {
        return this.logic;
    }
   
}
