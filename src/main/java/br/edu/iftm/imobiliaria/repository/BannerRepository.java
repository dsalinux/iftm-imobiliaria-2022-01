package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.Banner;

public class BannerRepository extends GenericRepository<Banner, Integer>{
    
    public BannerRepository() {
        super(Banner.class);
    }
    
}
