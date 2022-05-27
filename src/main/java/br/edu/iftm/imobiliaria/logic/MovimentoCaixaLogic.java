package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.MovimentoCaixa;
import br.edu.iftm.imobiliaria.repository.MovimentoCaixaRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class MovimentoCaixaLogic implements CrudLogic<MovimentoCaixa, Integer>{

    @Inject
    private MovimentoCaixaRepository repository;
    
    @Override
    public MovimentoCaixa salvar(MovimentoCaixa entidade)  throws ErroNegocioException, ErroSistemaException{
        if(Assert.isStringEmpty(entidade.getDescricao())){
           throw new ErroNegocioException("Informe a descrição.");
        }
        if(Assert.isNull(entidade.getTipoMovimento())){
           throw new ErroNegocioException("Selecione o tipo movimento.");
        }
        if(Assert.isNull(entidade.getDataMovimento())){
            entidade.setDataMovimento(new Date());
        }
        if(Assert.isNull(entidade.getValor()) || entidade.getValor().equals(BigDecimal.ZERO)){
           throw new ErroNegocioException("Informe o valor do movimento. O valor não pode ser zero.");
        }
        if(Assert.isNull(entidade.getTipoMoeda())){
           throw new ErroNegocioException("Selecione o tipo moeda.");
        }
        if(MovimentoCaixa.TipoMovimento.SAIDA.equals(entidade.getTipoMovimento())
                && entidade.getValor().compareTo(BigDecimal.ZERO) == 1){
            entidade.setValor(entidade.getValor().negate());
        }
        entidade = repository.salvar(entidade);
        return entidade;
    }

    @Override
    public void deletar(MovimentoCaixa entidade)  throws ErroNegocioException, ErroSistemaException{
        repository.remover(entidade.getId());
    }

    @Override
    public MovimentoCaixa bucarPorID(MovimentoCaixa entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.findById(entidade.getId());
    }

    @Override
    public List<MovimentoCaixa> buscar(MovimentoCaixa entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.buscar();
    }
    
}
