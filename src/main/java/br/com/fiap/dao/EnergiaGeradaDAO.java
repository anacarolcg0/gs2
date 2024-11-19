package br.com.fiap.dao;

import br.com.fiap.to.EnergiaGeradaTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnergiaGeradaDAO extends Repository {

    public ArrayList<EnergiaGeradaTO> findAll() {
        ArrayList<EnergiaGeradaTO> energiasGeradas = new ArrayList<EnergiaGeradaTO>();
        String sql = "select * from gs_energias_geradas order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    EnergiaGeradaTO energiaGerada = new EnergiaGeradaTO();
                    energiaGerada.setCodigo(rs.getLong("codigo"));
                    energiaGerada.setQuantidade(rs.getDouble("quantidade"));
                    energiaGerada.setTipoFonte(rs.getString("tipo_fonte"));
                    energiaGerada.setDataGeracao(rs.getDate("data_geracao").toLocalDate());
                    energiasGeradas.add(energiaGerada);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return energiasGeradas;
    }

    public EnergiaGeradaTO findByCodigo(Long codigo) {
        EnergiaGeradaTO energiaGerada = new EnergiaGeradaTO();
        String sql = "select * from gs_energias_geradas where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                energiaGerada.setCodigo(rs.getLong("codigo"));
                energiaGerada.setQuantidade(rs.getDouble("quantidade"));
                energiaGerada.setTipoFonte(rs.getString("tipo_fonte"));
                energiaGerada.setDataGeracao(rs.getDate("data_geracao").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return energiaGerada;
    }

    public EnergiaGeradaTO save(EnergiaGeradaTO energiaGerada) {
        String sql = "insert into gs_energias_geradas (quantidade, tipo_fonte, data_geracao) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, energiaGerada.getQuantidade());
            ps.setString(2, energiaGerada.getTipoFonte());
            ps.setDate(3, Date.valueOf(energiaGerada.getDataGeracao()));
            if (ps.executeUpdate() > 0) {
                return energiaGerada;
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
        String sql = "delete from gs_energias_geradas where codigo = ?";
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

    public EnergiaGeradaTO update(EnergiaGeradaTO energiaGerada) {
        String sql = "update gs_energias_geradas set quantidade=?, tipo_fonte=?, data_geracao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setDouble(1, energiaGerada.getQuantidade());
            ps.setString(2, energiaGerada.getTipoFonte());
            ps.setDate(3, Date.valueOf(energiaGerada.getDataGeracao()));
            ps.setLong(4, energiaGerada.getCodigo());
            if (ps.executeUpdate() > 0) {
                return energiaGerada;
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
