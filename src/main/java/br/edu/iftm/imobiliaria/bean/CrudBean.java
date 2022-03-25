package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.logic.CrudLogic;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class CrudBean<E, L extends CrudLogic<E, ?>> {
    
    private E entidade;
    private List<E> entidades;
    private Estado estado = Estado.BUSCAR;
    private Class<E> classeEntidade;
        
    private enum Estado {
        BUSCAR,
        CRIAR,
        EDITAR
    }
    
    public CrudBean(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }
    public void novo(){
        try {
            entidade = this.classeEntidade
                    .getDeclaredConstructor().newInstance();
            this.estado = Estado.CRIAR;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void salvar(){
        getLogic().salvar(entidade);
        this.estado = Estado.BUSCAR;
    }
    public void editar(E entidade){
        this.entidade = entidade;
        this.estado = Estado.EDITAR;
    }
    public void remover(E entidade){
        this.getLogic().deletar(entidade);
    }
    public void buscar(){
        if(!this.estado.equals(Estado.BUSCAR)){
           this.estado = Estado.BUSCAR;
           return;
        }
        this.entidades = getLogic().buscar(null);
    }
    
    public abstract L getLogic(); 
}
