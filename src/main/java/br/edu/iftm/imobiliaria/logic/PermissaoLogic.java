package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Permissao;
import br.edu.iftm.imobiliaria.repository.PermissaoRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class PermissaoLogic implements CrudLogic<Permissao, Integer>{

    @Inject
    private PermissaoRepository repository;
    
    @Override
    public Permissao salvar(Permissao entidade)  throws ErroNegocioException, ErroSistemaException{
        if(Assert.isStringEmpty(entidade.getNome())){
           throw new ErroNegocioException("Informe o nome.");
        }
        entidade = repository.salvar(entidade);
        return entidade;
    }

    @Override
    public void deletar(Permissao entidade)  throws ErroNegocioException, ErroSistemaException{
        repository.remover(entidade.getId());
    }

    @Override
    public Permissao bucarPorID(Permissao entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Permissao> buscar(Permissao entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.buscar();
    }
    
}
