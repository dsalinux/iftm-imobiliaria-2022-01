package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Usuario;

public class UsuarioRepository extends GenericRepository<Usuario, Integer>{

    public UsuarioRepository() {
        super(Usuario.class);
    }
}
