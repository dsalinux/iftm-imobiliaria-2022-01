package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.MovimentoCaixa;
import br.edu.iftm.imobiliaria.repository.MovimentoCaixaRepository;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class MovimentoCaixaLogic implements CrudLogic<MovimentoCaixa, Integer>{

    @Inject
    private MovimentoCaixaRepository repository;
    
    @Override
    public MovimentoCaixa salvar(MovimentoCaixa entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.salvar(entidade);
    }

    @Override
    public void deletar(MovimentoCaixa entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public MovimentoCaixa bucarPorID(MovimentoCaixa entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<MovimentoCaixa> buscar(MovimentoCaixa entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
