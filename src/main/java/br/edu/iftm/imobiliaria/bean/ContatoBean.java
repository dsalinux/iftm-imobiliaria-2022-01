package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Contato;
import br.edu.iftm.imobiliaria.entity.TipoMensagem;
import br.edu.iftm.imobiliaria.logic.ContatoLogic;
import br.edu.iftm.imobiliaria.logic.TipoMensagemLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import lombok.Getter;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
@Data
public class ContatoBean extends JSFUtil {
    
    private Contato contato = new Contato();
    
    @Inject
    private ContatoLogic logic;
    @Inject
    private TipoMensagemLogic tipoMensagemLogic;
    
    public void enviarMensagem(){
        try {
            this.logic.salvar(contato);
            addInfo("Mensagem enviada com ");
        } catch (ErroNegocioException ex) {
            Logger.getLogger(ContatoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(ContatoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<TipoMensagem> getTiposMensagens(){
        try {
            return this.tipoMensagemLogic.buscar(null);
        } catch (ErroNegocioException ex) {
            Logger.getLogger(ContatoBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(ContatoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
