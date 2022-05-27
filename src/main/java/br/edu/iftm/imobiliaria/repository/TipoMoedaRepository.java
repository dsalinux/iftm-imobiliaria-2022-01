package br.edu.iftm.imobiliaria.repository;

import br.edu.iftm.imobiliaria.entity.TipoMoeda;

public class TipoMoedaRepository extends GenericRepository<TipoMoeda, Integer>{

    public TipoMoedaRepository() {
        super(TipoMoeda.class);
    }
}
