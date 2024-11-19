package br.com.fiap.bo;

import br.com.fiap.dao.MonitoramentoDAO;
import br.com.fiap.to.MonitoramentoTO;

import java.util.ArrayList;

public class MonitoramentoBO {
    private MonitoramentoDAO monitoramentoDAO;

    public ArrayList<MonitoramentoTO> findAll() {
        monitoramentoDAO = new MonitoramentoDAO();
        // aqui se implementa a regra de negócios
        return monitoramentoDAO.findAll();
    }

    public MonitoramentoTO findByCodigo(Long codigo) {
        monitoramentoDAO = new MonitoramentoDAO();
        // aqui se implementa a regra de negócios
        return monitoramentoDAO.findByCodigo(codigo);
    }

    public MonitoramentoTO save(MonitoramentoTO monitoramento) {
        monitoramentoDAO = new MonitoramentoDAO();
        // aqui se implementa a regra de negócios
        return monitoramentoDAO.save(monitoramento);
    }

    public boolean delete(Long codigo) {
        monitoramentoDAO = new MonitoramentoDAO();
        // aqui se implementa a regra de negócios
        return monitoramentoDAO.delete(codigo);
    }

    public MonitoramentoTO update(MonitoramentoTO monitoramento) {
        monitoramentoDAO = new MonitoramentoDAO();
        // aqui se implementa a regra de negócios
        return monitoramentoDAO.update(monitoramento);
    }
}
