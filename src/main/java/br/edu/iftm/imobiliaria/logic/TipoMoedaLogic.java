package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.TipoMoeda;
import br.edu.iftm.imobiliaria.repository.TipoMoedaRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class TipoMoedaLogic implements CrudLogic<TipoMoeda, Integer>{

    @Inject
    private TipoMoedaRepository repository;
    
    @Override
    public TipoMoeda salvar(TipoMoeda entidade) throws ErroNegocioException, ErroSistemaException {
        if(Assert.isStringEmpty(entidade.getDescricao())){
            throw new ErroNegocioException("Nome do Tipo Mensagem Obrigatório.");
        }
        return repository.salvar(entidade);
        
    }

    @Override
    public void deletar(TipoMoeda entidade) throws ErroNegocioException, ErroSistemaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoMoeda bucarPorID(TipoMoeda entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<TipoMoeda> buscar(TipoMoeda entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
