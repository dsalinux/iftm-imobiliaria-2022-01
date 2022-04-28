package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.logic.CrudLogic;
import br.edu.iftm.imobiliaria.logic.UsuarioLogic;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic> {

    /*
    TODO: Tarefas para usuário
    - Problema para salvar senha
    - Configurar a senha para HASH SHA-256 @see HashUtil (MD5Util)
    - Configurar Gravatar
    - Selecionar Permissões
    - Relacionamento com JPA
    - Seleção de dados com Primefaces.
    */
    
    @Inject
    private UsuarioLogic logic;
    
    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public UsuarioLogic getLogic() {
        return this.logic;
    }
   
}
