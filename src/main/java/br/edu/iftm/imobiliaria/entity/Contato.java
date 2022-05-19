package br.edu.iftm.imobiliaria.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "contato")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Contato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String mensagem;
    
    @ManyToOne
    @JoinColumn(name = "tipo_mensagem")
    private TipoMensagem tipoMensagem;
    
}
