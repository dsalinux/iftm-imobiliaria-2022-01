package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Imagem;

public class ImagemRepository extends GenericRepository<Imagem, Integer>{
    
    public ImagemRepository() {
        super(Imagem.class);
    }
    
}
