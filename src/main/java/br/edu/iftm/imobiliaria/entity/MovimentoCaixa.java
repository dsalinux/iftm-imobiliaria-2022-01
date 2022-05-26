package br.edu.iftm.imobiliaria.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "movimento_caixa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MovimentoCaixa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String descricao;
    private String tipo_movimento;
    @Temporal(TemporalType.DATE)
    @Column(name="data_movimento")
    private Date dataMovimento;
    private float valor;
    private int tipo_moeda_id;
    
}
