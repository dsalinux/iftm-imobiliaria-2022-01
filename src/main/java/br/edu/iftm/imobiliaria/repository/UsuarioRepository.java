package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.util.Assert;
import java.util.List;
import javax.persistence.Query;

public class UsuarioRepository extends GenericRepository<Usuario, Integer>{

    public UsuarioRepository() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscar(Usuario usuario){
        Query query = getEntityManager().createQuery("from " + Usuario.class.getName() + " as usuario where usuario.email like :email");
        String email = "%";
        if(Assert.isStringNotEmpty(usuario.getEmail())){
            email += usuario.getEmail()+"%";
        }
        query.setParameter("email", email);
        List<Usuario> usuarios = query.getResultList();
        return usuarios;
    }
}
