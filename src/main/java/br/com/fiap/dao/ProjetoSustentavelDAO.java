package br.com.fiap.dao;

import br.com.fiap.to.ProjetoSustentavelTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProjetoSustentavelDAO extends Repository {

    public ArrayList<ProjetoSustentavelTO> findAll() {
        ArrayList<ProjetoSustentavelTO> projetosSustentaveis = new ArrayList<ProjetoSustentavelTO>();
        String sql = "select * from gs_projetos_sustentaveis order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ProjetoSustentavelTO projetoSustentavel = new ProjetoSustentavelTO();
                    projetoSustentavel.setCodigo(rs.getLong("codigo"));
                    projetoSustentavel.setDescricao(rs.getString("descricao"));
                    projetoSustentavel.setCusto(rs.getDouble("custo"));
                    projetoSustentavel.setStatus(rs.getString("status"));
                    projetosSustentaveis.add(projetoSustentavel);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return projetosSustentaveis;
    }

    public ProjetoSustentavelTO findByCodigo(Long codigo) {
        ProjetoSustentavelTO projetoSustentavel = new ProjetoSustentavelTO();
        String sql = "select * from gs_projetos_sustentaveis where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                projetoSustentavel.setCodigo(rs.getLong("codigo"));
                projetoSustentavel.setDescricao(rs.getString("descricao"));
                projetoSustentavel.setCusto(rs.getDouble("custo"));
                projetoSustentavel.setStatus(rs.getString("status"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return projetoSustentavel;
    }

    public ProjetoSustentavelTO save(ProjetoSustentavelTO projetoSustentavel) {
        String sql = "insert into gs_projetos_sustentaveis (descricao, custo, status) values(?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, projetoSustentavel.getDescricao());
            ps.setDouble(2, projetoSustentavel.getCusto());
            ps.setString(3, projetoSustentavel.getStatus());
            if (ps.executeUpdate() > 0) {
                return projetoSustentavel;
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
        String sql = "delete from gs_projetos_sustentaveis where codigo = ?";
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

    public ProjetoSustentavelTO update(ProjetoSustentavelTO projetoSustentavel) {
        String sql = "update gs_projetos_sustentaveis set descricao=?, custo=?, status=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, projetoSustentavel.getDescricao());
            ps.setDouble(2, projetoSustentavel.getCusto());
            ps.setString(3, projetoSustentavel.getStatus());
            ps.setLong(4, projetoSustentavel.getCodigo());
            if (ps.executeUpdate() > 0) {
                return projetoSustentavel;
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
