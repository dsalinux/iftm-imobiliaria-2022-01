package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Permissao;
import br.edu.iftm.imobiliaria.entity.Usuario;

public class PermissaoRepository extends GenericRepository<Permissao, Integer>{

    public PermissaoRepository() {
        super(Permissao.class);
    }
}
