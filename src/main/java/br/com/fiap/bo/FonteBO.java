package br.com.fiap.bo;

import br.com.fiap.dao.FonteDAO;
import br.com.fiap.to.FonteTO;

import java.util.ArrayList;

public class FonteBO {
    private FonteDAO fonteDAO;

    public ArrayList<FonteTO> findAll() {
        fonteDAO = new FonteDAO();
        // aqui se implementa a regra de negócios
        return fonteDAO.findAll();
    }

    public FonteTO findByCodigo(Long codigo) {
        fonteDAO = new FonteDAO();
        // aqui se implementa a regra de negócios
        return fonteDAO.findByCodigo(codigo);
    }

    public FonteTO save(FonteTO fonte) {
        fonteDAO = new FonteDAO();
        // aqui se implementa a regra de negócios
        return fonteDAO.save(fonte);
    }

    public boolean delete(Long codigo) {
        fonteDAO = new FonteDAO();
        // aqui se implementa a regra de negócios
        return fonteDAO.delete(codigo);
    }

    public FonteTO update(FonteTO fonte) {
        fonteDAO = new FonteDAO();
        // aqui se implementa a regra de negócios
        return fonteDAO.update(fonte);
    }
}
