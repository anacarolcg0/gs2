package br.com.fiap.dao;

import br.com.fiap.to.FeedbackTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FeedbackDAO extends Repository {
    public ArrayList<FeedbackTO> findAll() {
        ArrayList<FeedbackTO> feedbacks = new ArrayList<FeedbackTO>();
        String sql = "select * from gs_feedbacks order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    FeedbackTO feedback = new FeedbackTO();
                    feedback.setCodigo(rs.getLong("codigo"));
                    feedback.setComentario(rs.getString("comentario"));
                    feedback.setNota(rs.getInt("nota"));
                    feedback.setDataFeedback(rs.getDate("data_feedback").toLocalDate());
                    feedbacks.add(feedback);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return feedbacks;
    }

    public FeedbackTO findByCodigo(Long codigo) {
        FeedbackTO feedback = new FeedbackTO();
        String sql = "select * from gs_feedbacks where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                feedback.setCodigo(rs.getLong("codigo"));
                feedback.setComentario(rs.getString("comentario"));
                feedback.setNota(rs.getInt("nota"));
                feedback.setDataFeedback(rs.getDate("data_feedback").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return feedback;
    }

    public FeedbackTO save(FeedbackTO feedback) {
        String sql = "insert into gs_feedbacks (comentario, nota, data_feedback) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, feedback.getComentario());
            ps.setInt(2, feedback.getNota());
            ps.setDate(3, Date.valueOf(feedback.getDataFeedback()));
            if (ps.executeUpdate() > 0) {
                return feedback;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(Long codigo) {
        String sql = "delete from gs_feedbacks where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public FeedbackTO update(FeedbackTO feedback) {
        String sql = "update gs_feedbacks set comentario=?, nota=?, data_feedback=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, feedback.getComentario());
            ps.setInt(2, feedback.getNota());
            ps.setDate(3, Date.valueOf(feedback.getDataFeedback()));
            ps.setLong(4, feedback.getCodigo());
            if (ps.executeUpdate() > 0) {
                return feedback;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }
}
