package br.edu.iftm.imobiliaria.entity;

import javax.ws.rs.GET;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString(onlyExplicitlyIncluded = false)
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
public class Usuario {
    
    @EqualsAndHashCode.Include
    private Integer id;
    @ToString.Include
    private String nome;
    private String sobrenome;
    private String email;
    private String password;
    
    public String getPassword(){
        return "123"+this.password;
    }

}
