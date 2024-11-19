package br.com.fiap.bo;

import br.com.fiap.dao.TecnologiaRenovavelDAO;
import br.com.fiap.to.TecnologiaRenovavelTO;

import java.util.ArrayList;

public class TecnologiaRenovavelBO {
    private TecnologiaRenovavelDAO tecnologiaRenovavelDAO;

    public ArrayList<TecnologiaRenovavelTO> findAll() {
        tecnologiaRenovavelDAO = new TecnologiaRenovavelDAO();
        // aqui se implementa a regra de negócios
        return tecnologiaRenovavelDAO.findAll();
    }

    public TecnologiaRenovavelTO findByCodigo(Long codigo) {
        tecnologiaRenovavelDAO = new TecnologiaRenovavelDAO();
        // aqui se implementa a regra de negócios
        return tecnologiaRenovavelDAO.findByCodigo(codigo);
    }

    public TecnologiaRenovavelTO save(TecnologiaRenovavelTO tecnologiaRenovavel) {
        tecnologiaRenovavelDAO = new TecnologiaRenovavelDAO();
        // aqui se implementa a regra de negócios
        return tecnologiaRenovavelDAO.save(tecnologiaRenovavel);
    }

    public boolean delete(Long codigo) {
        tecnologiaRenovavelDAO = new TecnologiaRenovavelDAO();
        // aqui se implementa a regra de negócios
        return tecnologiaRenovavelDAO.delete(codigo);
    }

    public TecnologiaRenovavelTO update(TecnologiaRenovavelTO tecnologiaRenovavel) {
        tecnologiaRenovavelDAO = new TecnologiaRenovavelDAO();
        // aqui se implementa a regra de negócios
        return tecnologiaRenovavelDAO.update(tecnologiaRenovavel);
    }
}
