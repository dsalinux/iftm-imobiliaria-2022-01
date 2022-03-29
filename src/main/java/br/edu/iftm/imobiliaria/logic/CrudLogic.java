package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;

/**
 * Define uma interface genérica para o Crud.
 * @author danilo
 * @param <E> é uma classe de entidade.
 */
public interface CrudLogic<E, ID> extends Serializable{
    
    public E salvar(E entidade) throws ErroNegocioException, ErroSistemaException;
    public void deletar(E entidade) throws ErroNegocioException, ErroSistemaException;
    public E bucarPorID(ID id) throws ErroNegocioException, ErroSistemaException;
    public List<E> buscar(E entidade) throws ErroNegocioException, ErroSistemaException; 
    
}
