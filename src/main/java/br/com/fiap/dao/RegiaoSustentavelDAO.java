package br.com.fiap.dao;

import br.com.fiap.to.RegiaoSustentavelTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegiaoSustentavelDAO extends Repository {
    public ArrayList<RegiaoSustentavelTO> findAll() {
        ArrayList<RegiaoSustentavelTO> regioesSustentaveis = new ArrayList<RegiaoSustentavelTO>();
        String sql = "select * from gs_regioes_sustentaveis order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RegiaoSustentavelTO regiaoSustentavel = new RegiaoSustentavelTO();
                    regiaoSustentavel.setCodigo(rs.getLong("codigo"));
                    regiaoSustentavel.setNomeRegiao(rs.getString("nome_regiao"));
                    regiaoSustentavel.setPopulacao(rs.getInt("populacao"));
                    regiaoSustentavel.setEnergiaRenovavel(rs.getDouble("energia_renovavel"));
                    regioesSustentaveis.add(regiaoSustentavel);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return regioesSustentaveis;
    }

    public RegiaoSustentavelTO findByCodigo(Long codigo) {
        RegiaoSustentavelTO regiaoSustentavel = new RegiaoSustentavelTO();
        String sql = "select * from gs_regioes_sustentaveis where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                regiaoSustentavel.setCodigo(rs.getLong("codigo"));
                regiaoSustentavel.setNomeRegiao(rs.getString("nome_regiao"));
                regiaoSustentavel.setPopulacao(rs.getInt("populacao"));
                regiaoSustentavel.setEnergiaRenovavel(rs.getDouble("energia_renovavel"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return regiaoSustentavel;
    }

    public RegiaoSustentavelTO save(RegiaoSustentavelTO regiaoSustentavel) {
        String sql = "insert into gs_regioes_sustentaveis (nome_regiao, populacao, energia_renovavel) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, regiaoSustentavel.getNomeRegiao());
            ps.setInt(2, regiaoSustentavel.getPopulacao());
            ps.setDouble(3, regiaoSustentavel.getEnergiaRenovavel());
            if (ps.executeUpdate() > 0) {
                return regiaoSustentavel;
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
        String sql = "delete from gs_regioes_sustentaveis where codigo = ?";
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

    public RegiaoSustentavelTO update(RegiaoSustentavelTO regiaoSustentavel) {
        String sql = "update gs_regioes_sustentaveis set nome_regiao=?, populacao=?, energia_renovavel=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, regiaoSustentavel.getNomeRegiao());
            ps.setInt(2, regiaoSustentavel.getPopulacao());
            ps.setDouble(3, regiaoSustentavel.getEnergiaRenovavel());
            ps.setLong(4, regiaoSustentavel.getCodigo());
            if (ps.executeUpdate() > 0) {
                return regiaoSustentavel;
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
