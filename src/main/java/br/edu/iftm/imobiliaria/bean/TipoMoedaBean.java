/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.TipoMoeda;
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

@Named
@SessionScoped
public class TipoMoedaBean extends CrudBean<TipoMoeda, TipoMoedaLogic>{

    @Inject
    private TipoMoedaLogic logic;
    
    private List<TipoMoeda> listaTipoSuperiores = null;
    private Long ultimaAtualizacao = new Date().getTime();

    public TipoMoedaBean() {
        super(TipoMoeda.class);
    }
    
    @Override
    public TipoMoedaLogic getLogic() {
        return logic;
    }
    
    public List<TipoMoeda> getListaTiposSuperiores(){
        long agora = new Date().getTime();
        if(listaTipoSuperiores == null || ultimaAtualizacao<agora-5000){
            ultimaAtualizacao = agora;
            try {
                listaTipoSuperiores = logic.buscar(null);
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                addErro(ex);
                Logger.getLogger(TipoMoedaBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTipoSuperiores;
    }
    
}
