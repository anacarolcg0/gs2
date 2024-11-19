package br.com.fiap.bo;

import br.com.fiap.dao.RedeInteligenteDAO;
import br.com.fiap.to.RedeInteligenteTO;

import java.util.ArrayList;

public class RedeInteligenteBO {
    private RedeInteligenteDAO redeInteligenteDAO;

    public ArrayList<RedeInteligenteTO> findAll() {
        redeInteligenteDAO = new RedeInteligenteDAO();
        // aqui se implementa a regra de negócios
        return redeInteligenteDAO.findAll();
    }

    public RedeInteligenteTO findByCodigo(Long codigo) {
        redeInteligenteDAO = new RedeInteligenteDAO();
        // aqui se implementa a regra de negócios
        return redeInteligenteDAO.findByCodigo(codigo);
    }

    public RedeInteligenteTO save(RedeInteligenteTO redeInteligente) {
        redeInteligenteDAO = new RedeInteligenteDAO();
        // aqui se implementa a regra de negócios
        return redeInteligenteDAO.save(redeInteligente);
    }

    public boolean delete(Long codigo) {
        redeInteligenteDAO = new RedeInteligenteDAO();
        // aqui se implementa a regra de negócios
        return redeInteligenteDAO.delete(codigo);
    }

    public RedeInteligenteTO update(RedeInteligenteTO redeInteligente) {
        redeInteligenteDAO = new RedeInteligenteDAO();
        // aqui se implementa a regra de negócios
        return redeInteligenteDAO.update(redeInteligente);
    }
}
