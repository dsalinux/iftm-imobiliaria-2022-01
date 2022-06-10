package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.interceptors.anotation.Transacao;
import br.edu.iftm.imobiliaria.logic.CrudLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class CrudBean<E, L extends CrudLogic<E, ?>> extends JSFUtil {
    
    private E entidade;
    private List<E> entidades;
    private Estado estado = Estado.BUSCAR;
    private Class<E> classeEntidade;
        
    private enum Estado {
        BUSCAR,//Default
        CRIAR,
        EDITAR
    }
    
    public CrudBean(Class<E> classeEntidade) {
        try {
            this.classeEntidade = classeEntidade;
            entidade = this.classeEntidade
                    .getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            addErro("Erro ao tentar criar uma nova entidade.");
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void novo(){
        try {
            entidade = this.classeEntidade
                    .getDeclaredConstructor().newInstance();
            this.estado = Estado.CRIAR;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            addErro("Erro ao tentar criar uma nova entidade.");
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Transacao
    public void salvar(){
        try {
            getLogic().salvar(entidade);
            addInfo("Salvo com sucesso.");
            this.estado = Estado.BUSCAR;
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editar(E entidade){
        try {
            entidade = this.getLogic().bucarPorID(entidade);
            this.entidade = entidade;
            this.estado = Estado.EDITAR;
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            addErro(ex);
        }
    }
    
    @Transacao
    public void remover(E entidade){
        try {
            this.getLogic().deletar(entidade);
            this.entidades.remove(entidade);
            addInfo("Removido com sucesso.");
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void buscar(){
        try {
            if(!this.estado.equals(Estado.BUSCAR)){
                this.estado = Estado.BUSCAR;
                return;
            }
            this.entidades = getLogic().buscar(this.entidade);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public abstract L getLogic(); 
}
