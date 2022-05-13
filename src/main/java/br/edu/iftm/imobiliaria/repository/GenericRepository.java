package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Usuario;
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
        entityManager.getTransaction().begin();
        entidade = entityManager.merge(entidade);
        entityManager.getTransaction().commit();
        return entidade;
    }

    public void remover(ID id) {
        entityManager.getTransaction().begin();
        E entidade = entityManager.find(entityClass, id);
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
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
