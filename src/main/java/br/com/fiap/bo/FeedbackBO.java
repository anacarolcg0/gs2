package br.com.fiap.bo;

import br.com.fiap.dao.FeedbackDAO;
import br.com.fiap.to.FeedbackTO;

import java.util.ArrayList;

public class FeedbackBO {
    private FeedbackDAO feedbackDAO;

    public ArrayList<FeedbackTO> findAll() {
        feedbackDAO = new FeedbackDAO();
        // aqui se implementa a regra de negócios
        return feedbackDAO.findAll();
    }

    public FeedbackTO findByCodigo(Long codigo) {
        feedbackDAO = new FeedbackDAO();
        // aqui se implementa a regra de negócios
        return feedbackDAO.findByCodigo(codigo);
    }

    public FeedbackTO save(FeedbackTO feedback) {
        feedbackDAO = new FeedbackDAO();
        // aqui se implementa a regra de negócios
        return feedbackDAO.save(feedback);
    }

    public boolean delete(Long codigo) {
        feedbackDAO = new FeedbackDAO();
        // aqui se implementa a regra de negócios
        return feedbackDAO.delete(codigo);
    }

    public FeedbackTO update(FeedbackTO feedback) {
        feedbackDAO = new FeedbackDAO();
        // aqui se implementa a regra de negócios
        return feedbackDAO.update(feedback);
    }
}
