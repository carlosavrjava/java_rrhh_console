/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.echo.bitlab.entidades.Departamento;

/**
 *
 * @author NewBie
 */
public class DepartamentoDAO extends AbstractDAO<Departamento> {

    @Override
    protected Departamento getMappingResults(ResultSet rs) throws SQLException {
        return new Departamento(
                rs.getInt("iddepartamento"),
                rs.getString("nombre"),
                rs.getString("idubicacion")
        );
    }

    @Override
    protected void setMappingParamsToInsert(PreparedStatement ps, Departamento entity) throws SQLException {
        ps.setInt(1, entity.getIddepartamento());
        ps.setString(2, entity.getNombre());
        ps.setString(3, entity.getIdubicacion());
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Departamento entity) throws SQLException {
        ps.setInt(1, entity.getIddepartamento());
        ps.setString(2, entity.getNombre());
        ps.setString(3, entity.getIdubicacion());
        ps.setInt(4, entity.getIddepartamento());
    }

    @Override
    protected String getTableName() {
        return "departamento";
    }

    @Override
    public String[] getTableColumns() {
        String[] str = {
            "iddepartamento",
            "nombre",
            "idubicacion"
        };
        return str;
    }

    @Override
    protected String getTableKey() {
        return "iddepartamento";
    }

}
