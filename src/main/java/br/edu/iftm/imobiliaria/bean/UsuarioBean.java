package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Permissao;
import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.logic.CrudLogic;
import br.edu.iftm.imobiliaria.logic.PermissaoLogic;
import br.edu.iftm.imobiliaria.logic.UsuarioLogic;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class UsuarioBean extends CrudBean<Usuario, UsuarioLogic> {

    /*
    TODO: Tarefas para usuário
    # Problema para salvar senha
    # Configurar a senha para HASH SHA-256 @see HashUtil (MD5Util)
    # Configurar Gravatar
    # Selecionar Permissões
    # Relacionamento com JPA
    - Seleção de dados com Primefaces.
    */
    
    @Inject
    private UsuarioLogic logic;
    
    @Inject
    private PermissaoLogic permissaoLogic;
    
    public UsuarioBean() {
        super(Usuario.class);
    }

    @Override
    public UsuarioLogic getLogic() {
        return this.logic;
    }
   
    public List<Permissao> getPermissoes(){
        try {
            return permissaoLogic.buscar(null);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
}
