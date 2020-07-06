/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.echo.bitlab.entidades.Cargo;

/**
 *
 * @author NewBie
 */
public class CargoDAO extends AbstractDAO<Cargo> {

    @Override
    protected Cargo getMappingResults(ResultSet rs) throws SQLException {
        return new Cargo(
                rs.getString("idcargo"),
                rs.getString("nombre"),
                rs.getInt("sueldo_min"),
                rs.getInt("sueldo_max")
        );
    }

    @Override
    protected void setMappingParamsToInsert(PreparedStatement ps, Cargo entity) throws SQLException {
        ps.setString(1, entity.getIdcargo());
        ps.setString(2, entity.getNombre());
        ps.setInt(3, entity.getSueldo_min());
        ps.setInt(4, entity.getSueldo_max());
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Cargo entity) throws SQLException {
        ps.setString(1, entity.getIdcargo());
        ps.setString(2, entity.getNombre());
        ps.setInt(3, entity.getSueldo_min());
        ps.setInt(4, entity.getSueldo_max());
        ps.setString(5, entity.getIdcargo());
    }

    @Override
    protected String getTableName() {
        return "cargo";
    }

    @Override
    protected String[] getTableColumns() {
        String[] str = {
            "idcargo",
            "nombre",
            "sueldo_min",
            "sueldo_max"
        };
        return str;
    }

    @Override
    protected String getTableKey() {
        return "idcargo";
    }

}
