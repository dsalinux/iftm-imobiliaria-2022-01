package br.edu.iftm.imobiliaria.bean.site;

import br.edu.iftm.imobiliaria.entity.Banner;
import br.edu.iftm.imobiliaria.logic.BannerLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
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
public class BannerSiteBean extends JSFUtil {
    
    private Long ultimaConsulta = 0L;
    private Long tempoEntreConsultas = 5000L;
    private List<Banner> banners;
    
    @Inject
    private BannerLogic logic;
    
    public List<Banner> getBanners(){
        if(banners == null || (ultimaConsulta+tempoEntreConsultas) < new Date().getTime()) {
            try {
                banners = logic.buscar(null);
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                addErro(ex);
                Logger.getLogger(BannerSiteBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return banners;
    }
    
}
