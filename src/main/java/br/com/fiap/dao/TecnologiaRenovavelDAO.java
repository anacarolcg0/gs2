package br.com.fiap.dao;

import br.com.fiap.to.TecnologiaRenovavelTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TecnologiaRenovavelDAO extends Repository {

    public ArrayList<TecnologiaRenovavelTO> findAll() {
        ArrayList<TecnologiaRenovavelTO> tecnologiasRenovaveis = new ArrayList<TecnologiaRenovavelTO>();
        String sql = "select * from gs_tecnologias_renovaveis order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    TecnologiaRenovavelTO tecnologiaRenovavel = new TecnologiaRenovavelTO();
                    tecnologiaRenovavel.setCodigo(rs.getLong("codigo"));
                    tecnologiaRenovavel.setNome(rs.getString("nome"));
                    tecnologiaRenovavel.setTipoFonte(rs.getString("tipo_fonte"));
                    tecnologiaRenovavel.setEficiencia(rs.getDouble("eficiencia"));
                    tecnologiaRenovavel.setCustoProducao(rs.getDouble("custo_producao"));
                    tecnologiasRenovaveis.add(tecnologiaRenovavel);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return tecnologiasRenovaveis;
    }

    public TecnologiaRenovavelTO findByCodigo(Long codigo) {
        TecnologiaRenovavelTO tecnologiaRenovavel = new TecnologiaRenovavelTO();
        String sql = "select * from gs_tecnologias_renovaveis where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tecnologiaRenovavel.setCodigo(rs.getLong("codigo"));
                tecnologiaRenovavel.setNome(rs.getString("nome"));
                tecnologiaRenovavel.setTipoFonte(rs.getString("tipo_fonte"));
                tecnologiaRenovavel.setEficiencia(rs.getDouble("eficiencia"));
                tecnologiaRenovavel.setCustoProducao(rs.getDouble("custo_producao"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return tecnologiaRenovavel;
    }

    public TecnologiaRenovavelTO save(TecnologiaRenovavelTO tecnologiaRenovavel) {
        String sql = "insert into gs_tecnologias_renovaveis (nome, tipo_fonte, eficiencia, custo_producao) values(?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, tecnologiaRenovavel.getNome());
            ps.setString(2, tecnologiaRenovavel.getTipoFonte());
            ps.setDouble(3, tecnologiaRenovavel.getEficiencia());
            ps.setDouble(4, tecnologiaRenovavel.getCustoProducao());
            if (ps.executeUpdate() > 0) {
                return tecnologiaRenovavel;
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
        String sql = "delete from gs_tecnologias_renovaveis where codigo = ?";
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

    public TecnologiaRenovavelTO update(TecnologiaRenovavelTO tecnologiaRenovavel) {
        String sql = "update gs_tecnologias_renovaveis set nome=?, tipo_fonte=?, eficiencia=?, custo_producao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, tecnologiaRenovavel.getNome());
            ps.setString(2, tecnologiaRenovavel.getTipoFonte());
            ps.setDouble(3, tecnologiaRenovavel.getEficiencia());
            ps.setDouble(4, tecnologiaRenovavel.getCustoProducao());
            ps.setLong(5, tecnologiaRenovavel.getCodigo());
            if (ps.executeUpdate() > 0) {
                return tecnologiaRenovavel;
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
