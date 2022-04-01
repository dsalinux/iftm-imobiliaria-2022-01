/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class UsuarioRepository implements Serializable {

    @Inject
    private EntityManager entityManager;

    public Usuario salvar(Usuario entidade) {
        entityManager.getTransaction().begin();
        entidade = entityManager.merge(entidade);
        entityManager.getTransaction().commit();
        return entidade;
    }

    public void remover(Integer id) {
        entityManager.getTransaction().begin();
        Usuario entidade = entityManager.find(Usuario.class, id);
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
    }
    
    public List<Usuario> buscar(){
        List<Usuario> usuarios = entityManager.createQuery("from Usuario").getResultList();
        return usuarios;
    }

}
