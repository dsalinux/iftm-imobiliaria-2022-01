package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Sobre;
import br.edu.iftm.imobiliaria.interceptors.anotation.Transacao;
import br.edu.iftm.imobiliaria.logic.SobreLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class GerenciarSobreBean extends JSFUtil {

    @Inject
    private SobreLogic logic;
    
    @Getter
    private Sobre sobre;
    
    @PostConstruct
    private void init(){
        this.carregar();
    }
    
    @Transacao
    public void salvar(){
        try {
            sobre = this.logic.salvar(sobre);
            addInfo("Salvo com sucesso.");
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(GerenciarSobreBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void carregar(){
        try {
            sobre = this.logic.carregar();
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(GerenciarSobreBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
