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
import sv.echo.bitlab.entidades.Empleado;

/**
 *
 * @author NewBie
 */
public class EmpleadoDAO extends AbstractDAO<Empleado> {

    @Override
    public String getTableName() {
        return "empleado";
    }

    @Override
    public String getTableKey() {
        return "idempleado";
    }

    @Override
    public String[] getTableColumns() {
        String[] str = {"idempleado", "apellido", "nombre", "fecingreso", "email", "telefono", "idcargo", "iddepartamento", "sueldo", "comision", "jefe", "fecegreso"};
        return str;
    }

    @Override
    protected Empleado getMappingResults(ResultSet rs) throws SQLException {
        return new Empleado(
                rs.getString("idempleado"),
                rs.getString("apellido"),
                rs.getString("nombre"),
                rs.getDate("fecingreso"),
                rs.getString("email"),
                rs.getString("telefono"),
                rs.getString("idcargo"),
                rs.getInt("iddepartamento"),
                rs.getInt("sueldo"),
                rs.getInt("comision"),
                rs.getString("jefe"),
                rs.getDate("fecegreso")
        );
    }

    @Override
    public void setMappingParamsToInsert(PreparedStatement ps, Empleado entity) throws SQLException {
        ps.setString(1, entity.getIdempleado());
        ps.setString(2, entity.getApellido());
        ps.setString(3, entity.getNombre());
        ps.setDate(4, entity.getFecingreso());
        ps.setString(5, entity.getEmail());
        ps.setString(6, entity.getTelefono());
        ps.setString(7, entity.getIdcargo());
        ps.setInt(8, entity.getIddepartamento());
        ps.setInt(9, entity.getSueldo());
        ps.setInt(10, entity.getComision());
        ps.setString(11, entity.getJefe());
        ps.setDate(12, entity.getFecegreso());
    }

    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Empleado entity) throws SQLException {
        ps.setString(1, entity.getIdempleado());
        ps.setString(2, entity.getApellido());
        ps.setString(3, entity.getNombre());
        ps.setDate(4, entity.getFecingreso());
        ps.setString(5, entity.getEmail());
        ps.setString(6, entity.getTelefono());
        ps.setString(7, entity.getIdcargo());
        ps.setInt(8, entity.getIddepartamento());
        ps.setInt(9, entity.getSueldo());
        ps.setInt(10, entity.getComision());
        ps.setString(11, entity.getJefe());
        // este parametro es para la condicion del where
        ps.setDate(12, entity.getFecegreso());
        ps.setString(13, entity.getIdempleado());
    }
    
}
