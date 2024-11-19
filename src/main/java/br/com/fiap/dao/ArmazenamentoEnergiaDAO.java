package br.com.fiap.dao;

import br.com.fiap.to.ArmazenamentoEnergiaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ArmazenamentoEnergiaDAO extends Repository {

    public ArrayList<ArmazenamentoEnergiaTO> findAll() {
        ArrayList<ArmazenamentoEnergiaTO> armazenamentoEnergias = new ArrayList<ArmazenamentoEnergiaTO>();
        String sql = "select * from gs_armazenamento_energias order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ArmazenamentoEnergiaTO armazenamentoEnergia = new ArmazenamentoEnergiaTO();
                    armazenamentoEnergia.setCodigo(rs.getLong("codigo"));
                    armazenamentoEnergia.setTipo(rs.getString("tipo"));
                    armazenamentoEnergia.setCapacidade(rs.getDouble("capacidade"));
                    armazenamentoEnergia.setCusto(rs.getDouble("custo"));
                    armazenamentoEnergias.add(armazenamentoEnergia);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return armazenamentoEnergias;
    }

    public ArmazenamentoEnergiaTO findByCodigo(Long codigo) {
        ArmazenamentoEnergiaTO armazenamentoEnergia = new ArmazenamentoEnergiaTO();
        String sql = "select * from gs_armazenamento_energias where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                armazenamentoEnergia.setCodigo(rs.getLong("codigo"));
                armazenamentoEnergia.setTipo(rs.getString("tipo"));
                armazenamentoEnergia.setCapacidade(rs.getDouble("capacidade"));
                armazenamentoEnergia.setCusto(rs.getDouble("custo"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return armazenamentoEnergia;
    }

    public ArmazenamentoEnergiaTO save(ArmazenamentoEnergiaTO armazenamentoEnergia) {
        String sql = "insert into gs_armazenamento_energias (tipo, capacidade, custo) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, armazenamentoEnergia.getTipo());
            ps.setDouble(2, armazenamentoEnergia.getCapacidade());
            ps.setDouble(3, armazenamentoEnergia.getCusto());
            if (ps.executeUpdate() > 0) {
                return armazenamentoEnergia;
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
        String sql = "delete from gs_armazenamento_energias where codigo = ?";
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

    public ArmazenamentoEnergiaTO update(ArmazenamentoEnergiaTO armazenamentoEnergia) {
        String sql = "update gs_armazenamento_energias set tipo=?, capacidade=?, custo=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, armazenamentoEnergia.getTipo());
            ps.setDouble(2, armazenamentoEnergia.getCapacidade());
            ps.setDouble(3, armazenamentoEnergia.getCusto());
            ps.setLong(4, armazenamentoEnergia.getCodigo());
            if (ps.executeUpdate() > 0) {
                return armazenamentoEnergia;
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
