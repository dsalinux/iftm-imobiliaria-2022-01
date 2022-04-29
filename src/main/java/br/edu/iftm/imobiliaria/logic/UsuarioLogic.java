package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.repository.UsuarioRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.HashUtil;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

public class UsuarioLogic implements CrudLogic<Usuario, Integer>{

    @Inject
    private UsuarioRepository repository;
    
    @Override
    public Usuario salvar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        if(Assert.isStringEmpty(entidade.getNome())){
           throw new ErroNegocioException("Informe o nome.");
        }
        if(Assert.isInvalidEmail(entidade.getEmail())){
           throw new ErroNegocioException("Informe um email válido.");
        }
        if(Assert.isStringEmpty(entidade.getSenha())
                && Assert.isStringEmpty(entidade.getNovaSenha())){
           throw new ErroNegocioException("Informe uma senha.");
        }
        if(Assert.isNull(entidade.getDataCadastro())){
            entidade.setDataCadastro(new Date());
        }
        if(Assert.isStringNotEmpty(entidade.getNovaSenha())){
            entidade.setSenha(HashUtil.sha256Hex(entidade.getNovaSenha()));
            
        }
        entidade.setSalt(1233465L);
        
        entidade = repository.salvar(entidade);
        return entidade;
    }

    @Override
    public void deletar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        repository.remover(entidade.getId());
    }

    @Override
    public Usuario bucarPorID(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.findById(entidade.getId());
    }

    @Override
    public List<Usuario> buscar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.buscar();
    }
    
}
