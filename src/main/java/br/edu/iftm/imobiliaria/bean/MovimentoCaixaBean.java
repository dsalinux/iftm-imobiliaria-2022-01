package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.MovimentoCaixa;
import br.edu.iftm.imobiliaria.entity.TipoMoeda;
import br.edu.iftm.imobiliaria.logic.MovimentoCaixaLogic;
import br.edu.iftm.imobiliaria.logic.TipoMoedaLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class MovimentoCaixaBean extends CrudBean<MovimentoCaixa, MovimentoCaixaLogic> {

    @Inject
    private MovimentoCaixaLogic logic;
    
    @Inject
    private TipoMoedaLogic tipoMoedaLogic;
    
    private List<TipoMoeda> tiposMoeda;
    private Long ultimaAtualizacao = new Date().getTime()-5000;
    
    public MovimentoCaixaBean() {
        super(MovimentoCaixa.class);
    }

    @Override
    public MovimentoCaixaLogic getLogic() {
        return this.logic;
    }
   
    public List<TipoMoeda> getTiposMoeda(){
        long agora = new Date().getTime();
        if(tiposMoeda == null || ultimaAtualizacao<agora-5000){
            ultimaAtualizacao = agora;
            try {
                tiposMoeda = tipoMoedaLogic.buscar(null);
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                addErro(ex);
                Logger.getLogger(TipoMensagemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tiposMoeda;
    }
    
}
