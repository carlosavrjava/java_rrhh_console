/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.echo.bitlab.dao.*;
import sv.echo.bitlab.entidades.*;

/**
 *
 * @author rgluis
 */
public class TestLoad implements Runnable {

    @Override
    public void run() {
        // Para mostrar los datos almacenados en DB RECURSOS
        CargoDAO cargoDAO = new CargoDAO();
        for (int i = 0; i <= 10; i++) {
            try {
                List<Cargo> cargo = cargoDAO.getAllData();
                cargo = null;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TestLoad.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TestLoad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

//        EmployeesDAO employeesDAO = new EmployeesDAO();
//        for(int i = 0; i<=10; i++)
//            try {
//                List<Employe> employees = employeesDAO.getAllData();
//                employees = null;
//            } catch (ClassNotFoundException ex) {
//                Logger.getLogger(TestLoad.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SQLException ex) {
//                Logger.getLogger(TestLoad.class.getName()).log(Level.SEVERE, null, ex);
//            }
    }

}
