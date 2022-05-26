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
            try {
                logic.uploadToSystem(file);
                FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    @Override
    public ImagemLogic getLogic() {
        return this.logic;
    }

}
