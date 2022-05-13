package br.edu.iftm.imobiliaria.entity;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "tipo_mensagem")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TipoMensagem implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "tipo_mensagem_id")
    private TipoMensagem tipoMensagemSuperior;
    
}
