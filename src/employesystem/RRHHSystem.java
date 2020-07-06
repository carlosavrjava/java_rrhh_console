/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import sv.echo.bitlab.dao.EmpleadoDAO;
import sv.echo.bitlab.entidades.Empleado;

/**
 *
 * @author cVasquez
 */
public class RRHHSystem {

    //Se deberá parametrizar y encriptar
    private static Logger log = Logger.getLogger(RRHHSystem.class.getName());

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            List<Empleado> empleado = empleadoDAO.getAllData(1);
            for (Empleado e : empleado) {
                System.out.println(e.getApellido());
                log.info(e.toString());
            }

//            
//            EmployeesDAO employeesDAO = new EmployeesDAO();
//            List<Employe> employees = employeesDAO.getAllData(10);
//            for (Employe e : employees) {
//                log.info(e.toString());
//            }
//            //Obtenindo el primer registro
//
//            Employe e = employees.get(0);
//            log.info("Actualizando el Empleado " + e + " con los datos Carlos Perez");
//            e.setFirstName("Carlos");
//            e.setLastName("Perez");
            // actualizando empleado
            Empleado e = empleado.get(0);
            log.info("sueldo actual del empleado"+e.getSueldo());
            e.setSueldo(750);
            empleadoDAO.updateData(e);

//            //Actualizando al empleado
//            employeesDAO.updateData(e);
//            log.info("Empleado actualizado");
//
            //Creando fecha de ingreso a la empresa
            GregorianCalendar gc = new GregorianCalendar();
            gc.set(GregorianCalendar.DATE, 01);
            gc.set(GregorianCalendar.MONTH, 06);
            gc.set(GregorianCalendar.YEAR, 2020);

            // Creando nuevo empleado para insert a tabla empleado
            Empleado nuevoEmpleado = new Empleado("NUEVO", "apellidoEmpleado", "nombreEmpleado", new Date(gc.getTimeInMillis()), "nuevoEmpleado@gmail.com", "76543210", "C07", 105, 1, 0, "E0012");
            empleadoDAO.insertData(nuevoEmpleado);
            log.info("Nuevo Empleado creado exitosamente");
//            Employe eLuis = new Employe(1000000, new Date(gc.getTimeInMillis()), "Luis", "Rugamas", "M", new Date(new GregorianCalendar().getTimeInMillis()));
//            log.info("Creando el empleado " + eLuis);
//            employeesDAO.insertData(eLuis);
//            log.info("Empleado creado exitosamente");
//

            // Recuperando el NUEVO empleado de la base de datos
            nuevoEmpleado = empleadoDAO.getByIDData("NUEVO");
            log.info("Info recuperada: " + nuevoEmpleado);
//            //Recuperando a Luis de la BD
//            log.info("Recuperando al empleado 1000000 de la BD");
//            eLuis = employeesDAO.getByIDData(1000000);
//            log.info("Información del empleado: " + eLuis);

//            // eliminando nuevo empleado comprobando metodo
//            log.info("Eliminando al Nuevo Empleado");
//            empleadoDAO.deleteData(nuevoEmpleado.getIdempleado());
//            log.info("Eliminado Existoso");

//           //Eliminando a Luis
//           log.info("Eliminando al empleado Luis Rugamas");
//           employeesDAO.deleteData(eLuis.getIdEmploye());
//           log.info("Eliminado Existoso");

        } catch (Exception e) {
            e.printStackTrace();;
        }

    }

}
