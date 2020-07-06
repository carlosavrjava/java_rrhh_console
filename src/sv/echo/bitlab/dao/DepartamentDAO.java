/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.echo.bitlab.entidades.Departaments;

/**
 *
 * @author rgluis
 */
public class DepartamentDAO extends AbstractDAO<Departaments>{

    @Override
    protected Departaments getMappingResults(ResultSet rs) throws SQLException {
          return new Departaments(rs.getString("dept_no"), rs.getString("dept_name"));
    }


    @Override
    public void setMappingParamsToInsert(PreparedStatement ps, Departaments entity) throws SQLException {
        ps.setString(1, entity.getCode());
        ps.setString(2, entity.getName());
    }
    
    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Departaments entity) throws SQLException {
        ps.setString(1, entity.getCode());
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getCode());
    }

    @Override
    public String getTableName() {
        return "departaments";
    }

    @Override
    public String[] getTableColumns() {
        String[] columns = {"dept_no","dept_name"};
        return columns;
    }
    
    @Override
    public String getTableKey() {
        return "dept_no";
    }
    




    
    
}
