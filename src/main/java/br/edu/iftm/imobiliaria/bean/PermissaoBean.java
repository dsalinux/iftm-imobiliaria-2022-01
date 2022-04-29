package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Permissao;
import br.edu.iftm.imobiliaria.logic.PermissaoLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class PermissaoBean extends CrudBean<Permissao, PermissaoLogic> {

    @Inject
    private PermissaoLogic logic;
    
    public PermissaoBean() {
        super(Permissao.class);
    }

    @Override
    public PermissaoLogic getLogic() {
        return this.logic;
    }
   
}
