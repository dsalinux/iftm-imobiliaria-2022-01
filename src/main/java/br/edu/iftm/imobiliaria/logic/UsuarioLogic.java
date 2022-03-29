package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioLogic implements CrudLogic<Usuario, Integer>{

    @Override
    public Usuario salvar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        if("".equals(entidade.getNome())){
           throw new ErroNegocioException("Informe o nome.");
        }
        return null;
    }

    @Override
    public void deletar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
    }

    @Override
    public Usuario bucarPorID(Integer id)  throws ErroNegocioException, ErroSistemaException{
        return null;
    }

    @Override
    public List<Usuario> buscar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        return new ArrayList<>();
    }
    
}
