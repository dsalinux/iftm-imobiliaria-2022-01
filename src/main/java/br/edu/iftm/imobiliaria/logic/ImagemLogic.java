package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.repository.ImagemRepository;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

public class ImagemLogic implements CrudLogic<Imagem, Integer>{

    @Inject
    private ImagemRepository repository;
    
    @Override
    public Imagem salvar(Imagem entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.salvar(entidade);
    }

    @Override
    public void deletar(Imagem entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Imagem bucarPorID(Imagem entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Imagem> buscar(Imagem entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
