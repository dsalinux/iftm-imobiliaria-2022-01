package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Cliente;

public class ClienteRepository extends GenericRepository<Cliente, Integer>{
    
    public ClienteRepository() {
        super(Cliente.class);
    }
    
}
