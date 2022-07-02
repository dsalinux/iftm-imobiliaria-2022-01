package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Usuario;
import br.edu.iftm.imobiliaria.repository.UsuarioRepository;
import br.edu.iftm.imobiliaria.util.Assert;
import br.edu.iftm.imobiliaria.util.HashUtil;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.hibernate.Hibernate;

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
            try {
                SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
                entidade.setSalt(secureRandom.nextLong());
                String senhaSalt = entidade.getNovaSenha() + entidade.getSalt();
                entidade.setSenha(HashUtil.sha256Hex(senhaSalt));
                
            } catch (NoSuchAlgorithmException ex) {
                throw new ErroSistemaException("Erro na criptografia de Senha.", ex);
            }
        }
        
        entidade = repository.salvar(entidade);
        return entidade;
    }

    @Override
    public void deletar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        repository.remover(entidade.getId());
    }

    @Override
    public Usuario bucarPorID(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        Usuario u = repository.findById(entidade.getId());
        u.getPermissoes().size();
        return u;
    }

    @Override
    public List<Usuario> buscar(Usuario entidade)  throws ErroNegocioException, ErroSistemaException{
        return repository.buscar(entidade);
    }
    
}
