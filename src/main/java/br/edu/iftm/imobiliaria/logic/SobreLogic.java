package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Sobre;
import br.edu.iftm.imobiliaria.repository.SobreRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.inject.Inject;

public class SobreLogic implements Serializable{

    @Inject
    private SobreRepository repository;

    public Sobre salvar(Sobre entidade) throws ErroNegocioException, ErroSistemaException {

        if(Assert.isStringEmpty(entidade.getTitulo())){
            throw new ErroNegocioException("Por favor informe o título.");
        }
        if(Assert.isStringEmpty(entidade.getTexto())){
            throw new ErroNegocioException("Por favor informe o título.");
        }
        entidade = this.repository.salvar(entidade);
        return entidade;
    }

    public Sobre carregar() throws ErroNegocioException, ErroSistemaException {
        Sobre sobre = repository.findById(1);
        if(Assert.isNull(sobre)) {
            sobre = new Sobre();
            sobre.setId(1);
        }
        return sobre;
    }

}
