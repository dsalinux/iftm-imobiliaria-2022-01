package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class UsuarioBean implements Serializable {
    
    @Getter @Setter
    private Usuario usuario = new Usuario();
    @Getter @Setter
    private List<Usuario> usuarios = new ArrayList();
    private Integer id = 1;
    @Getter
    private String estado = "PESQUISANDO";
    
    public void novo(){
        this.usuario = new Usuario();
        estado = "CRIANDO";
    }
    
    public void salvar(){
        usuario.setId(id++);
        this.usuarios.add(usuario);
        usuario = new Usuario();
        estado = "PESQUISANDO";
    }
    public void deletar(Integer id) {
        Usuario u = new Usuario();
        u.setId(id);
        System.out.println("%%%%%%%%%%%%% "+id);
        Integer index = this.usuarios.lastIndexOf(u);
        System.out.println("%%%%%%%%%%%%% "+index);
        this.usuarios.remove(u);
        estado = "PESQUISANDO";
    }
    public void editar(Usuario u){
        this.usuario = u;
        estado = "EDITANDO";
    }
    
}
