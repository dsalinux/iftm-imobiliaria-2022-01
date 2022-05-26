package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Endereco;

public class EnderecoRepository extends GenericRepository<Endereco, Integer>{
    
    public EnderecoRepository() {
        super(Endereco.class);
    }
    
}
