package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Usuario;
import java.io.Serializable;
import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class TesteBean implements Serializable{
    
    private String nome;
    
    public void dizerOla(){
        long terminarEm = new Date().getTime()+2000;
        while(terminarEm > new Date().getTime()){
            
        }
//        FacesContext fc = FacesContext.getCurrentInstance();
//        Usuario usuario = new Usuario();
//        usuario.setNome(nome);
//        fc.addMessage(null, new FacesMessage("Olá "+ usuario));
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        
    
}
