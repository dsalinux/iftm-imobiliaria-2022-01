package br.edu.iftm.imobiliaria.entity;

import br.edu.iftm.imobiliaria.util.HashUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Long salt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_cadastro")
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_desativacao")
    private Date dataDesativacao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="data_expiracao_senha")
    private Date dataExpiracaoSenha;
    
    @ManyToMany
    @JoinTable(name = "usuario_permissao",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id")}
    )        
    private List<Permissao> permissoes;
    
    @Transient
    private String novaSenha;
    
    public String getEmailMD5Hash(){
        return HashUtil.md5Hex(email);
    }
}
