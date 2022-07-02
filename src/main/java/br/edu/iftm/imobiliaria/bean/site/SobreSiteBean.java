package br.edu.iftm.imobiliaria.bean.site;

import br.edu.iftm.imobiliaria.entity.Sobre;
import br.edu.iftm.imobiliaria.logic.SobreLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
import java.util.Date;
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
public class SobreSiteBean extends JSFUtil {
    
    private Long ultimaConsulta = 0L;
    private Long tempoEntreConsultas = 5000L;
    private Sobre sobre;
    
    @Inject
    private SobreLogic logic;
    
    public Sobre getSobre(){
        if(sobre == null || (ultimaConsulta+tempoEntreConsultas) < new Date().getTime()) {
            try {
                sobre = logic.carregar();
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                addErro(ex);
                Logger.getLogger(SobreSiteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return sobre;
    }
    
}
