package br.edu.iftm.imobiliaria.logic;

import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.repository.ImagemRepository;
import br.edu.iftm.imobiliaria.util.Constants;
import br.edu.iftm.imobiliaria.util.HashUtil;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.inject.Inject;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

public class ImagemLogic implements CrudLogic<Imagem, Integer> {

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
    
    public File getImagemPorCodigo(String codigo) {
        String diretorioUsuario = System.getProperty("user.home");
        Path imagem = Paths.get(diretorioUsuario, Constants.DIRETORIO_IMAGEM, codigo);
        return imagem.toFile();
    }

    public Imagem uploadToSystem(UploadedFile file) throws Exception {
        String ext = FilenameUtils.getExtension(file.getFileName());
        ext = ext.toLowerCase();
        if (!(ext.equals("png") || ext.equals("jpg") || ext.equals("jpeg"))) {
            return null;
        }
        String hash = HashUtil.sha256Hex(file.getContent());
        System.out.println("\n\n\n\n"+hash.length()+"\n\n\n");
        String diretorioUsuario = System.getProperty("user.home");
        Path diretorio = Paths.get(diretorioUsuario, Constants.DIRETORIO_IMAGEM);
        if(!diretorio.toFile().exists()) {
            diretorio.toFile().mkdir();
        }
        if (diretorio.toFile().exists()) {

            Path arquivo = Paths.get(diretorio.toAbsolutePath().toString(), hash + "." + ext);
            InputStream input = file.getInputStream();
            Files.copy(input, arquivo);
            Imagem imagem = new Imagem();
            imagem.setContent_type(ext);
            imagem.setUrl(arquivo.getFileName().toString());
            imagem = salvar(imagem);
            return imagem;
        }
        return null;
    }
}
