package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.TipoMensagem;
import br.edu.iftm.imobiliaria.repository.TipoMensagemRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class TipoMensagemLogic implements CrudLogic<TipoMensagem, Integer>{

    @Inject
    private TipoMensagemRepository repository;
    
    @Override
    public TipoMensagem salvar(TipoMensagem entidade) throws ErroNegocioException, ErroSistemaException {
        if(Assert.isStringEmpty(entidade.getNome())){
            throw new ErroNegocioException("Nome do Tipo Mensagem Obrigatório.");
        }
        return repository.salvar(entidade);
        
    }

    @Override
    public void deletar(TipoMensagem entidade) throws ErroNegocioException, ErroSistemaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoMensagem bucarPorID(TipoMensagem entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<TipoMensagem> buscar(TipoMensagem entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
