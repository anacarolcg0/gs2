package br.com.fiap.bo;

import br.com.fiap.dao.RegiaoSustentavelDAO;
import br.com.fiap.to.RegiaoSustentavelTO;

import java.util.ArrayList;

public class RegiaoSustentavelBO {
    private RegiaoSustentavelDAO regiaoSustentavelDAO;

    public ArrayList<RegiaoSustentavelTO> findAll() {
        regiaoSustentavelDAO = new RegiaoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return regiaoSustentavelDAO.findAll();
    }

    public RegiaoSustentavelTO findByCodigo(Long codigo) {
        regiaoSustentavelDAO = new RegiaoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return regiaoSustentavelDAO.findByCodigo(codigo);
    }

    public RegiaoSustentavelTO save(RegiaoSustentavelTO regiaoSustentavel) {
        regiaoSustentavelDAO = new RegiaoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return regiaoSustentavelDAO.save(regiaoSustentavel);
    }

    public boolean delete(Long codigo) {
        regiaoSustentavelDAO = new RegiaoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return regiaoSustentavelDAO.delete(codigo);
    }

    public RegiaoSustentavelTO update(RegiaoSustentavelTO regiaoSustentavel) {
        regiaoSustentavelDAO = new RegiaoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return regiaoSustentavelDAO.update(regiaoSustentavel);
    }
}
