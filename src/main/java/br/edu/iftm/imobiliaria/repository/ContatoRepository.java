package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Contato;

public class ContatoRepository extends GenericRepository<Contato, Integer>{

    public ContatoRepository() {
        super(Contato.class);
    }
    
    
}
