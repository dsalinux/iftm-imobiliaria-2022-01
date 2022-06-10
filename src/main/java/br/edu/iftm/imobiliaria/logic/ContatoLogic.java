package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Contato;
import br.edu.iftm.imobiliaria.interceptors.anotation.Transacao;
import br.edu.iftm.imobiliaria.repository.ContatoRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class ContatoLogic implements CrudLogic<Contato, Integer>{

    @Inject
    private ContatoRepository repository;
    
    @Override
    public Contato salvar(Contato entidade) throws ErroNegocioException, ErroSistemaException {
        if(Assert.isStringEmpty(entidade.getNome())){
            throw new ErroNegocioException("Nome do Tipo Mensagem Obrigatório.");
        }
        if(Assert.isStringEmpty(entidade.getTelefone()) &&
                Assert.isStringEmpty(entidade.getEmail())){
            throw new ErroNegocioException("Informe o telefone ou o email.");
        }
        if(Assert.isStringEmpty(entidade.getMensagem())) {
            throw new ErroNegocioException("Informe a mensagem.");
        }
        return repository.salvar(entidade);
        
    }

    @Override
    public void deletar(Contato entidade) throws ErroNegocioException, ErroSistemaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Contato bucarPorID(Contato entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Contato> buscar(Contato entidade) throws ErroNegocioException, ErroSistemaException {
        return repository.buscar();
    }
    
}
