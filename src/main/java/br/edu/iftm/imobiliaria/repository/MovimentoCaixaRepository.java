package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.MovimentoCaixa;

public class MovimentoCaixaRepository extends GenericRepository<MovimentoCaixa, Integer>{
    
    public MovimentoCaixaRepository() {
        super(MovimentoCaixa.class);
    }
    
}
