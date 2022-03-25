package br.edu.iftm.imobiliaria.logic;

import java.io.Serializable;
import java.util.List;

/**
 * Define uma interface genérica para o Crud.
 * @author danilo
 * @param <E> é uma classe de entidade.
 */
public interface CrudLogic<E, ID> extends Serializable{
    
    public E salvar(E entidade);
    public void deletar(E entidade);
    public E bucarPorID(ID id);
    public List<E> buscar(E entidade); 
    
}
