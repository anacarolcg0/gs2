package br.com.fiap.bo;

import br.com.fiap.dao.ArmazenamentoEnergiaDAO;
import br.com.fiap.to.ArmazenamentoEnergiaTO;

import java.util.ArrayList;

public class ArmazenamentoEnergiaBO {
    private ArmazenamentoEnergiaDAO armazenamentoEnergiaDAO;

    public ArrayList<ArmazenamentoEnergiaTO> findAll() {
        armazenamentoEnergiaDAO = new ArmazenamentoEnergiaDAO();
        // aqui se implementa a regra de negócios
        return armazenamentoEnergiaDAO.findAll();
    }

    public ArmazenamentoEnergiaTO findByCodigo(Long codigo) {
        armazenamentoEnergiaDAO = new ArmazenamentoEnergiaDAO();
        // aqui se implementa a regra de negócios
        return armazenamentoEnergiaDAO.findByCodigo(codigo);
    }

    public ArmazenamentoEnergiaTO save(ArmazenamentoEnergiaTO armazenamentoEnergia) {
        armazenamentoEnergiaDAO = new ArmazenamentoEnergiaDAO();
        // aqui se implementa a regra de negócios
        return armazenamentoEnergiaDAO.save(armazenamentoEnergia);
    }

    public boolean delete(Long codigo) {
        armazenamentoEnergiaDAO = new ArmazenamentoEnergiaDAO();
        // aqui se implementa a regra de negócios
        return armazenamentoEnergiaDAO.delete(codigo);
    }

    public ArmazenamentoEnergiaTO update(ArmazenamentoEnergiaTO armazenamentoEnergia) {
        armazenamentoEnergiaDAO = new ArmazenamentoEnergiaDAO();
        // aqui se implementa a regra de negócios
        return armazenamentoEnergiaDAO.update(armazenamentoEnergia);
    }
}
