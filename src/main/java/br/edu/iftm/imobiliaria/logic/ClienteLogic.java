package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Cliente;
import br.edu.iftm.imobiliaria.repository.ClienteRepository;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class ClienteLogic implements CrudLogic<Cliente, Integer>{

    @Inject
    private ClienteRepository repository;
    
    @Override
    public Cliente salvar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.salvar(entidade);
    }

    @Override
    public void deletar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Cliente bucarPorID(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Cliente> buscar(Cliente entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
