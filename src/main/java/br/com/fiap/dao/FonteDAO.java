package br.com.fiap.dao;

import br.com.fiap.to.FonteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FonteDAO extends Repository {

    public ArrayList<FonteTO> findAll() {
        ArrayList<FonteTO> fontes = new ArrayList<FonteTO>();
        String sql = "select * from gs_fontes order by codigo";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    FonteTO fonte = new FonteTO();
                    fonte.setCodigo(rs.getLong("codigo"));
                    fonte.setTipo(rs.getString("tipo"));
                    fonte.setCapacidade(rs.getDouble("capacidade"));
                    fonte.setLocalizacao(rs.getString("localizacao"));
                    fonte.setDescricao(rs.getString("descricao"));
                    fontes.add(fonte);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return fontes;
    }

    public FonteTO findByCodigo(Long codigo) {
        FonteTO fonte = new FonteTO();
        String sql = "select * from gs_fontes where codigo = ?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fonte.setCodigo(rs.getLong("codigo"));
                fonte.setTipo(rs.getString("tipo"));
                fonte.setCapacidade(rs.getDouble("capacidade"));
                fonte.setLocalizacao(rs.getString("localizacao"));
                fonte.setDescricao(rs.getString("descricao"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return fonte;
    }

    public FonteTO save(FonteTO fonte) {
        String sql = "insert into gs_fontes (tipo, capacidade, localizacao, descricao) values(?, ?, ?, ?)";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, fonte.getTipo());
            ps.setDouble(2, fonte.getCapacidade());
            ps.setString(3, fonte.getLocalizacao());
            ps.setString(4, fonte.getDescricao());
            if (ps.executeUpdate() > 0) {
                return fonte;
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
        String sql = "delete from gs_fontes where codigo = ?";
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

    public FonteTO update(FonteTO fonte) {
        String sql = "update gs_fontes set tipo=?, capacidade=?, localizacao=?, descricao=? where codigo=?";
        try(PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, fonte.getTipo());
            ps.setDouble(2, fonte.getCapacidade());
            ps.setString(3, fonte.getLocalizacao());
            ps.setString(4, fonte.getDescricao());
            ps.setLong(5, fonte.getCodigo());
            if (ps.executeUpdate() > 0) {
                return fonte;
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
