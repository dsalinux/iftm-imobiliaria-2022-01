package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Cliente;
import br.edu.iftm.imobiliaria.logic.ClienteLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class ClienteBean extends CrudBean<Cliente, ClienteLogic>{
    
    @Inject
    private ClienteLogic logic;

    public ClienteBean() {
        super(Cliente.class);
    }
    
    
    
    @Override
    public ClienteLogic getLogic() {
        return this.logic;
    }
    
}
