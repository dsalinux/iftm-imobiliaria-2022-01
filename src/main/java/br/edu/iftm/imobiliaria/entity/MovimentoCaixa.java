package br.edu.iftm.imobiliaria.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "movimento_caixa")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MovimentoCaixa  implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimento")
    private TipoMovimento tipoMovimento = TipoMovimento.ENTRADA;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_movimento")
    private Date dataMovimento;
    
    private BigDecimal valor;
    
    @ManyToOne
    @JoinColumn(name = "tipo_moeda_id")
    private TipoMoeda tipoMoeda;
    
    public enum TipoMovimento {
        ENTRADA,
        SAIDA
    }
}
