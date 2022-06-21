package br.edu.iftm.imobiliaria.bean;

import br.edu.iftm.imobiliaria.entity.Imagem;
import br.edu.iftm.imobiliaria.interceptors.anotation.Transacao;
import br.edu.iftm.imobiliaria.logic.ImagemLogic;
import br.edu.iftm.imobiliaria.util.exception.ErroNegocioException;
import br.edu.iftm.imobiliaria.util.exception.ErroSistemaException;
import br.edu.iftm.imobiliaria.utila.JSFUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFiles;

@Named
@SessionScoped
public class ImagemBean extends JSFUtil {

    @Inject
    private ImagemLogic logic;
    @Getter
    @Setter
    private UploadedFiles files;


    @Transacao
    public void upload(FileUploadEvent uploadEvent) {
        if (uploadEvent.getFile() != null) {
            try {
                logic.uploadToSystem(uploadEvent.getFile());
                FacesMessage message = new FacesMessage("Imagens enviadas.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
    
    public List<Imagem> getImagens() {
        try {
            return logic.buscar(null);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        } catch (ErroSistemaException ex) {
            addErro(ex);
            Logger.getLogger(ImagemBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }


}
