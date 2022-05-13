/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.TipoMensagem;
import br.edu.iftm.imobiliaria.logic.TipoMensagemLogic;
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
public class TipoMensagemBean extends CrudBean<TipoMensagem, TipoMensagemLogic>{

    @Inject
    private TipoMensagemLogic logic;
    
    private List<TipoMensagem> listaTipoSuperiores = null;
    private Long ultimaAtualizacao = new Date().getTime();

    public TipoMensagemBean() {
        super(TipoMensagem.class);
    }
    
    @Override
    public TipoMensagemLogic getLogic() {
        return logic;
    }
    
    public List<TipoMensagem> getListaTiposSuperiores(){
        long agora = new Date().getTime();
        if(listaTipoSuperiores == null || ultimaAtualizacao<agora-5000){
            ultimaAtualizacao = agora;
            try {
                listaTipoSuperiores = logic.buscar(null);
            } catch (ErroNegocioException ex) {
                addAviso(ex);
            } catch (ErroSistemaException ex) {
                addErro(ex);
                Logger.getLogger(TipoMensagemBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaTipoSuperiores;
    }
    
}
