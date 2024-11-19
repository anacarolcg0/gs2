package br.com.fiap.dao;

import br.com.fiap.to.MonitoramentoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonitoramentoDAO extends Repository {

    public ArrayList<MonitoramentoTO> findAll() {
        ArrayList<MonitoramentoTO> monitoramentos = new ArrayList<MonitoramentoTO>();
        String sql = "select * from gs_monitoramentos order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MonitoramentoTO monitoramento = new MonitoramentoTO();
                    monitoramento.setCodigo(rs.getLong("codigo"));
                    monitoramento.setNomeDaFonte(rs.getString("nome_da_fonte"));
                    monitoramento.setStatus(rs.getString("status"));
                    monitoramento.setEnergiaGerada(rs.getDouble("energia_gerada"));
                    monitoramento.setObservacao(rs.getString("observacao"));
                    monitoramentos.add(monitoramento);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return monitoramentos;
    }

    public MonitoramentoTO findByCodigo(Long codigo) {
        MonitoramentoTO monitoramento = new MonitoramentoTO();
        String sql = "select * from gs_monitoramentos where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                monitoramento.setCodigo(rs.getLong("codigo"));
                monitoramento.setNomeDaFonte(rs.getString("nome_da_fonte"));
                monitoramento.setStatus(rs.getString("status"));
                monitoramento.setEnergiaGerada(rs.getDouble("energia_gerada"));
                monitoramento.setObservacao(rs.getString("observacao"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return monitoramento;
    }

    public MonitoramentoTO save(MonitoramentoTO monitoramento) {
        String sql = "insert into gs_monitoramentos (nome_da_fonte, status, energia_gerada, observacao) values(?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, monitoramento.getNomeDaFonte());
            ps.setString(2, monitoramento.getStatus());
            ps.setDouble(3, monitoramento.getEnergiaGerada());
            ps.setString(4, monitoramento.getObservacao());
            if (ps.executeUpdate() > 0) {
                return monitoramento;
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
        String sql = "delete from gs_monitoramentos where codigo = ?";
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

    public MonitoramentoTO update(MonitoramentoTO monitoramento) {
        String sql = "update gs_monitoramentos set nome_da_fonte=?, status=?, energia_gerada=?, observacao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, monitoramento.getNomeDaFonte());
            ps.setString(2, monitoramento.getStatus());
            ps.setDouble(3, monitoramento.getEnergiaGerada());
            ps.setString(4, monitoramento.getObservacao());
            ps.setLong(5, monitoramento.getCodigo());
            if (ps.executeUpdate() > 0) {
                return monitoramento;
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
