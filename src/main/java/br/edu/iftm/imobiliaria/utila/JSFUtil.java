package br.edu.iftm.imobiliaria.utila;

import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author danilo
 */
public class JSFUtil implements Serializable {
    
    public void addMenssagem(FacesMessage.Severity tipoMenssagem, 
            String resumo, String detalhe) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        context.addMessage(null, 
                new FacesMessage(tipoMenssagem, resumo, detalhe));
    }
    
    public void addInfo(String resumo, String detalhe){
        addMenssagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }
    public void addInfo(String detalhe){
        addInfo("Info", detalhe);
    }
    
    public void addAviso(String resumo, String detalhe){
        addMenssagem(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addAviso(String detalhe){
        addAviso("Aviso", detalhe);
    }
    public void addAviso(ErroNegocioException ex){
        addAviso("Aviso", ex.getMessage());
    }
    public void addErro(String resumo, String detalhe){
        addMenssagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addErro(String detalhe){
        addErro("Erro", detalhe);
    }
    public void addErro(ErroSistemaException ex){
        addErro("Erro", ex.getMessage());
    }
    
}
