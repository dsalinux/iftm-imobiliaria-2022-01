package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Banner;
import br.edu.iftm.imobiliaria.repository.BannerRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.HashUtil;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Hibernate;

public class BannerLogic implements CrudLogic<Banner, Integer>{
 
    @Inject
    private BannerRepository repository;
    
    @Override
    public Banner salvar(Banner entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.salvar(entidade);
    }

    @Override
    public void deletar(Banner entidade) throws ErroNegocioException, ErroSistemaException {
        repository.remover(entidade.getId());
    }

    @Override
    public Banner bucarPorID(Banner entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Banner> buscar(Banner entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
