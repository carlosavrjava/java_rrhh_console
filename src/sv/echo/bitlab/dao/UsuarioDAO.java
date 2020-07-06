/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.echo.bitlab.entidades.Usuario;

/**
 *
 * @author NewBie
 */
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @Override
    protected Usuario getMappingResults(ResultSet rs) throws SQLException {
        return new Usuario(
                rs.getString("idempleado"),
                rs.getString("usuario"),
                rs.getString("clave"),
                rs.getInt("estado")
        );
    }

    @Override
    protected void setMappingParamsToInsert(PreparedStatement ps, Usuario entity) throws SQLException {
        ps.setString(1, entity.getIdempleado());
        ps.setString(2, entity.getUsuario());
        ps.setString(3, entity.getClave());
        ps.setInt(4, entity.getEstado());
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Usuario entity) throws SQLException {
        ps.setString(1, entity.getIdempleado());
        ps.setString(2, entity.getUsuario());
        ps.setString(3, entity.getClave());
        ps.setInt(4, entity.getEstado());
        ps.setString(5, entity.getIdempleado());
    }

    @Override
    protected String getTableName() {
        return "usuario";
    }

    @Override
    protected String[] getTableColumns() {
        String[] str = {
            "idempleado",
            "usuario",
            "clave",
            "estado"
        };
        return str;
    }

    @Override
    protected String getTableKey() {
        return "idempleado";
    }

}
