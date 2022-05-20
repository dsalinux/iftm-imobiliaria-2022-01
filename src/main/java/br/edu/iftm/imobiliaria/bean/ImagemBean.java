package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.logic.ImagemLogic;
import br.edu.iftm.imobiliaria.util.HashUtil;
import br.edu.iftm.imobiliaria.util.ImagemUtil;
import java.io.File;
import java.io.InputStream;

import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.Random;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;

@Named
@SessionScoped
public class ImagemBean extends CrudBean<Imagem, ImagemLogic> {

    @Inject
    private ImagemLogic logic;
    @Getter
    @Setter
    private UploadedFile file;

    public ImagemBean() {
        super(Imagem.class);
    }

    public void upload() {
        if (file != null) {
            String hash = HashUtil.sha256Hex(file.getContent());
            //enquanto não for alterado o banco de dados
            hash = hash.substring(0, 59);

            String ext = FilenameUtils.getExtension(file.getFileName());
            String diretorioUsuario = System.getProperty("user.home");
            //Criar uma verificação se o diretório existe
            Path diretorio = Paths.get(diretorioUsuario + "/NetBeansProjects/iftm-imobiliaria-2022-01/iftm-imobiliaria-2022-01/src/test/imagens");
            // Path diretorio = Paths.get(diretorioUsuario+"/Documents/NetBeansProjects/iftm-imobiliaria-2022-01/src/test/imagens");
            Path arquivo = Paths.get(diretorio.toAbsolutePath() + "/" + hash + "." + ext);

            try {
                InputStream input = file.getInputStream();
                Files.copy(input, arquivo);
            } catch (Exception e) {
                System.out.println(e);
            }
       
            this.getEntidade().setContent_type(ext);
            this.getEntidade().setUrl(hash);
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            this.salvar();
        }
    }

    @Override
    public ImagemLogic getLogic() {
        return this.logic;
    }

}
