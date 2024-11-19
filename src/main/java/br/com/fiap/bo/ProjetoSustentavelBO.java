package br.com.fiap.bo;

import br.com.fiap.dao.ProjetoSustentavelDAO;
import br.com.fiap.to.ProjetoSustentavelTO;

import java.util.ArrayList;

public class ProjetoSustentavelBO {
    private ProjetoSustentavelDAO projetoSustentavelDAO;

    public ArrayList<ProjetoSustentavelTO> findAll() {
        projetoSustentavelDAO = new ProjetoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return projetoSustentavelDAO.findAll();
    }

    public ProjetoSustentavelTO findByCodigo(Long codigo) {
        projetoSustentavelDAO = new ProjetoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return projetoSustentavelDAO.findByCodigo(codigo);
    }

    public ProjetoSustentavelTO save(ProjetoSustentavelTO projetoSustentavel) {
        projetoSustentavelDAO = new ProjetoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return projetoSustentavelDAO.save(projetoSustentavel);
    }

    public boolean delete(Long codigo) {
        projetoSustentavelDAO = new ProjetoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return projetoSustentavelDAO.delete(codigo);
    }

    public ProjetoSustentavelTO update(ProjetoSustentavelTO projetoSustentavel) {
        projetoSustentavelDAO = new ProjetoSustentavelDAO();
        // aqui se implementa a regra de negócios
        return projetoSustentavelDAO.update(projetoSustentavel);
    }
}
