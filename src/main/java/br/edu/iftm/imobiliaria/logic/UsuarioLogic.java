package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Usuario;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLogic implements CrudLogic<Usuario, Integer>{

    @Override
    public Usuario salvar(Usuario entidade) {
        return null;
    }

    @Override
    public void deletar(Usuario entidade) {
    }

    @Override
    public Usuario bucarPorID(Integer id) {
        return null;
    }

    @Override
    public List<Usuario> buscar(Usuario entidade) {
        return new ArrayList<>();
    }
    
}
