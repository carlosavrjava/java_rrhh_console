/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sv.echo.bitlab.entidades.Employe;

/**
 *
 * @author rgluis
 */
public class EmployeesDAO extends AbstractDAO<Employe>{


   
    @Override
    public String getTableName() {
        return "employees";
    }
    
    @Override
    public String getTableKey() {
        return "emp_no";
    }

    @Override
    public String[] getTableColumns() {
        String[] str = {"emp_no","birth_date","first_name","last_name","gender","hire_date"};
        return str;
    }

    @Override
    protected Employe getMappingResults(ResultSet rs) throws SQLException{
            return new Employe(
                        rs.getInt("emp_no"), 
                        rs.getDate("birth_date"), 
                        rs.getString("first_name"), 
                        rs.getString("last_name"), 
                        rs.getString("gender"), 
                        rs.getDate("hire_date"));
    }

    
    @Override
    public void setMappingParamsToInsert(PreparedStatement ps, Employe entity) throws SQLException {
        ps.setInt(      1, entity.getIdEmploye());
        ps.setDate(     2, entity.getBirthDate());
        ps.setString(   3, entity.getFirstName());
        ps.setString(   4, entity.getLastName());
        ps.setString(   5, entity.getGender());
        ps.setDate(     6, entity.getHireDate());
    }



    @Override
    protected void setMappingParamsToUpdate(PreparedStatement ps, Employe entity) throws SQLException {
        ps.setInt(      1, entity.getIdEmploye());
        ps.setDate(     2, entity.getBirthDate());
        ps.setString(   3, entity.getFirstName());
        ps.setString(   4, entity.getLastName());
        ps.setString(   5, entity.getGender());
        ps.setDate(     6, entity.getHireDate());
        ps.setInt(      7, entity.getIdEmploye());
    }
    
}
