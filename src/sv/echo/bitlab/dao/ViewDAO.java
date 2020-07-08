/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.echo.bitlab.entidades.*;

/**
 *
 * @author NewBie
 */
public class ViewDAO extends AbstractDAO<View> {

    @Override
    protected View getMappingResults(ResultSet rs) throws SQLException {
        return new View(
                rs.getString("idempleado"),
                rs.getString("apellido"),
                rs.getString("nombre"),
                rs.getInt("sueldo"),
                rs.getInt("comision"),
                rs.getInt("total"),
                rs.getDouble("afp"),
                rs.getDouble("isss")
        );
    }

    @Override
    protected void setMappingParamsToInsert(PreparedStatement ps, View entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, View entity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getTableName() {
        return "view";
    }

    @Override
    protected String[] getTableColumns() {
        String[] str = {
            "idempleado",
            "apellido",
            "nombre",
            "sueldo",
            "comision",
            "total",
            "afp",
            "isss"
        };
        return str;
    }

    @Override
    protected String getTableKey() {
        return "idempleado";
    }

}
