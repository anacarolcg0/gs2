package br.com.fiap.dao;

import br.com.fiap.to.RedeInteligenteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RedeInteligenteDAO extends Repository {

    public ArrayList<RedeInteligenteTO> findAll() {
        ArrayList<RedeInteligenteTO> redesInteligentes = new ArrayList<RedeInteligenteTO>();
        String sql = "select * from gs_redes_inteligentes order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    RedeInteligenteTO redeInteligente = new RedeInteligenteTO();
                    redeInteligente.setCodigo(rs.getLong("codigo"));
                    redeInteligente.setNome(rs.getString("nome"));
                    redeInteligente.setEficienciaDistribuicao(rs.getDouble("eficiencia_distribuicao"));
                    redeInteligente.setPerdaEnergia(rs.getDouble("perda_energia"));
                    redesInteligentes.add(redeInteligente);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return redesInteligentes;
    }

    public RedeInteligenteTO findByCodigo(Long codigo) {
        RedeInteligenteTO redeInteligente = new RedeInteligenteTO();
        String sql = "select * from gs_redes_inteligentes where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                redeInteligente.setCodigo(rs.getLong("codigo"));
                redeInteligente.setNome(rs.getString("nome"));
                redeInteligente.setEficienciaDistribuicao(rs.getDouble("eficiencia_distribuicao"));
                redeInteligente.setPerdaEnergia(rs.getDouble("perda_energia"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return redeInteligente;
    }

    public RedeInteligenteTO save(RedeInteligenteTO redeInteligente) {
        String sql = "insert into gs_redes_inteligentes (nome, eficiencia_distribuicao, perda_energia) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, redeInteligente.getNome());
            ps.setDouble(2, redeInteligente.getEficienciaDistribuicao());
            ps.setDouble(3, redeInteligente.getPerdaEnergia());
            if (ps.executeUpdate() > 0) {
                return redeInteligente;
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
        String sql = "delete from gs_redes_inteligentes where codigo = ?";
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

    public RedeInteligenteTO update(RedeInteligenteTO redeInteligente) {
        String sql = "update gs_redes_inteligentes set nome=?, eficiencia_distribuicao=?, perda_energia=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, redeInteligente.getNome());
            ps.setDouble(2, redeInteligente.getEficienciaDistribuicao());
            ps.setDouble(3, redeInteligente.getPerdaEnergia());
            ps.setLong(4, redeInteligente.getCodigo());
            if (ps.executeUpdate() > 0) {
                return redeInteligente;
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
