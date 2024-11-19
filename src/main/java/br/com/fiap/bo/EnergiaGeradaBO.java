package br.com.fiap.bo;

import br.com.fiap.dao.EnergiaGeradaDAO;
import br.com.fiap.to.EnergiaGeradaTO;

import java.util.ArrayList;

public class EnergiaGeradaBO {
    private EnergiaGeradaDAO energiaGeradaDAO;

    public ArrayList<EnergiaGeradaTO> findAll() {
        energiaGeradaDAO = new EnergiaGeradaDAO();
        // aqui se implementa a regra de negócios
        return energiaGeradaDAO.findAll();
    }

    public EnergiaGeradaTO findByCodigo(Long codigo) {
        energiaGeradaDAO = new EnergiaGeradaDAO();
        // aqui se implementa a regra de negócios
        return energiaGeradaDAO.findByCodigo(codigo);
    }

    public EnergiaGeradaTO save(EnergiaGeradaTO energiaGerada) {
        energiaGeradaDAO = new EnergiaGeradaDAO();
        // aqui se implementa a regra de negócios
        return energiaGeradaDAO.save(energiaGerada);
    }

    public boolean delete(Long codigo) {
        energiaGeradaDAO = new EnergiaGeradaDAO();
        // aqui se implementa a regra de negócios
        return energiaGeradaDAO.delete(codigo);
    }

    public EnergiaGeradaTO update(EnergiaGeradaTO energiaGerada) {
        energiaGeradaDAO = new EnergiaGeradaDAO();
        // aqui se implementa a regra de negócios
        return energiaGeradaDAO.update(energiaGerada);
    }
}
