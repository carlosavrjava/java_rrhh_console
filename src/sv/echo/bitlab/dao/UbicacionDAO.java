/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sv.echo.bitlab.entidades.Ubicacion;

/**
 *
 * @author NewBie
 */
public class UbicacionDAO extends AbstractDAO<Ubicacion> {

    @Override
    protected Ubicacion getMappingResults(ResultSet rs) throws SQLException {
        return new Ubicacion(
                rs.getString("idubicacion"),
                rs.getString("ciudad"),
                rs.getString("direccion")
        );
    }

    @Override
    protected void setMappingParamsToInsert(PreparedStatement ps, Ubicacion entity) throws SQLException {
        ps.setString(1, entity.getIdubicacion());
        ps.setString(2, entity.getCiudad());
        ps.setString(3, entity.getDireccion());
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Ubicacion entity) throws SQLException {
        ps.setString(1, entity.getIdubicacion());
        ps.setString(2, entity.getCiudad());
        ps.setString(3, entity.getDireccion());
        ps.setString(4, entity.getIdubicacion());
    }

    @Override
    protected String getTableName() {
        return "ubicacion";
    }

    @Override
    protected String[] getTableColumns() {
        String[] str = {
            "idubicacion",
            "ciudad",
            "direccion"
        };
        return str;
    }

    @Override
    protected String getTableKey() {
        return "idubicacion";
    }

}
