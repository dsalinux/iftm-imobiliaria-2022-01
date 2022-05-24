package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.MovimentoCaixa;
import br.edu.iftm.imobiliaria.logic.MovimentoCaixaLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class MovimentoCaixaBean extends CrudBean<MovimentoCaixa, MovimentoCaixaLogic>{
    
    @Inject
    private MovimentoCaixaLogic logic;

    public MovimentoCaixaBean() {
        super(MovimentoCaixa.class);
    }
    
    
    
    @Override
    public MovimentoCaixaLogic getLogic() {
        return this.logic;
    }
    
}
