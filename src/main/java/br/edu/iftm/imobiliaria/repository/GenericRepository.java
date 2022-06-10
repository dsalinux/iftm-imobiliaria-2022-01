package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.interceptors.anotation.Transacao;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public abstract class GenericRepository<E, ID> implements Serializable {
    
    @Inject
    private EntityManager entityManager;

    private Class<E> entityClass;
    
    public GenericRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    public E salvar(E entidade) {
        entidade = entityManager.merge(entidade);
        return entidade;
    }

    public void remover(ID id) {
        E entidade = entityManager.find(entityClass, id);
        entityManager.remove(entidade);
    }
    
    public E findById(ID id){
        E entidade = entityManager.find(entityClass, id);
        return entidade;
    }
    
    public List<E> buscar(){
        List<E> entidades = entityManager.createQuery("from "+getEntityClassName()).getResultList();
        return entidades;
    }
    
    public String getEntityClassName(){
        return this.entityClass.getCanonicalName();
    }
    public EntityManager getEntityManager(){
        return this.entityManager;
    }
}
