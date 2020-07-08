/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.codejava.security.HashGenerationException;
import net.codejava.security.HashGeneratorUtils;
import sv.echo.bitlab.dao.*;
import sv.echo.bitlab.entidades.*;

/**
 *
 * @author NewBie
 */
public class AppServices {

    private static Logger log = Logger.getLogger(AppServices.class.getName());

    // voy a pintar los datos almacenados en la base de datos 
    // segun la tabla que pase por parametro
    public static void verDatos(String banderaTabla) {
        try {
            if (banderaTabla.toUpperCase().equals("EMPLEADO")) {
                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                List<Empleado> resultView = empleadoDAO.getAllData(100);
                // muestro la tabla resultados segun boolean bandera
                for (Empleado e : resultView) {
                    System.out.println(e.toTableView());
                }
            } else if (banderaTabla.toUpperCase().equals("DEPARTAMENTO")) {
                DepartamentoDAO departamentoDAO = new DepartamentoDAO();
                List<Departamento> resultView = departamentoDAO.getAllData(100);
                // muestro la tabla resultados segun boolean bandera
                for (Departamento e : resultView) {
                    System.out.println(e.toTableView());
                }
            } else if (banderaTabla.toUpperCase().equals("USUARIO")) {
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                List<Usuario> resultView = usuarioDAO.getAllData(100);
                // muestro la tabla resultados segun boolean bandera
                for (Usuario u : resultView) {
                    System.out.println(u.toTableView());
                }
            } else if (banderaTabla.toUpperCase().equals("PLANILLA")) {
               
                ViewDAO viewDAO = new ViewDAO();
                List<View> resultView = viewDAO.getAllData(100);
                for (View v :resultView) {
                    System.out.println(v.toTableView());
                }
            } else {
                System.out.println("no valido el parametro");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void desactivarEmpleado() {
        verDatos("Empleado");
        String opcionTemp = Menu.leerId();
        try {
            // Scanner scanner = new Scanner(System.in);

            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado e = empleadoDAO.getByIDData(opcionTemp);
            // capturando la fecha actual
            Calendar calendar = Calendar.getInstance();
            java.sql.Date endDate = new java.sql.Date(calendar.getTime().getTime());
            // set fecha egreso
            e.setFecegreso(endDate);
            empleadoDAO.updateData(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void agregarEmpleado() throws SQLException {
        //String Value = Menu.leerString();

        // leerString
        verDatos("Empleado");

        // idEmpleado
        System.out.println("Cree Codigo Empleado (EXXXX): ");
        String idValue = Menu.leerString();

        // nombre
        System.out.println("Ingrese Nombre: ");
        String nombreValue = Menu.leerString();

        // apellido
        System.out.println("Ingrese Apellido: ");
        String apellidoValue = Menu.leerString();

        // fechaIngreso
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

        // email
        System.out.println("Ingrese Email: ");
        String emailValue = Menu.leerString();

        // telefono
        System.out.println("Ingrese Telefono: ");
        String telefonoValue = Menu.leerString();

        // cargo
        verDatos("Cargo");
        System.out.println("Seleccione codigo Cargo");
        String cargoValue = Menu.leerString();

        //departamento
        verDatos("Departamento");
        System.out.println("Seleccione codigo Departamento");
        String deptoValue = Menu.leerString();

        // sueldo
        System.out.println("Ingrese Sueldo: ");
        String sueldoValue = Menu.leerString();

        // comision
        System.out.println("Ingrese comsion (bono sobre salario base) : ");
        String comisionValue = Menu.leerString();

        // jefe
        System.out.println("Ingrese Jefe (EXXXX): ");
        String jefeValue = Menu.leerString();

        // creando la conexion DAO
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();

        // (1000000, new Date(gc.getTimeInMillis()), "Luis", "Rugamas", "M", new Date(new GregorianCalendar().getTimeInMillis()));
        Empleado eNuevo = new Empleado(
                idValue.toUpperCase(),
                nombreValue,
                apellidoValue,
                startDate,
                emailValue,
                telefonoValue,
                cargoValue,
                Integer.parseInt(deptoValue),
                Integer.parseInt(sueldoValue),
                Integer.parseInt(comisionValue),
                jefeValue,
                null);
        log.info("Creando el empleado " + eNuevo);
        try {
            empleadoDAO.insertData(eNuevo);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void actualizarDepto() {
//        
        System.out.println("Especifique el empleado a Modificar");
        verDatos("Empleado");

        String opcionTemp = Menu.leerId();
        try {
            // Scanner scanner = new Scanner(System.in);

            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado e = empleadoDAO.getByIDData(opcionTemp);
            // capturando la fecha actual

            verDatos("Departamento");
            short idDeptoValue = Menu.leerOpcion(1, 1000);
            // set fecha egreso
            e.setIddepartamento(idDeptoValue);
            empleadoDAO.updateData(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void actualizarJefe() {
        System.out.println("Especifique el empleado a Modificar");
        verDatos("Empleado");

        String opcionTemp = Menu.leerString();
        try {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado e = empleadoDAO.getByIDData(opcionTemp);
            // capturando la fecha actual

            String idJefeValue = Menu.leerString();
            // set fecha egreso
            e.setJefe(idJefeValue.toUpperCase());
            empleadoDAO.updateData(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void actualizarSalario() {
        System.out.println("Especifique el empleado a Modificar");
        verDatos("Empleado");
        String opcionTemp = Menu.leerId();
        try {
            // Scanner scanner = new Scanner(System.in);

            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado e = empleadoDAO.getByIDData(opcionTemp);
            // capturando la fecha actual

            //verDatos("Departamento");
            System.out.println("SALARIO = SALARIO BASE + COMISION");
            // salario
            System.out.println("Salario Base es ");
            short salarioValue = (short) Short.parseShort(Menu.leerString());
            // set fecha egreso
            e.setSueldo(salarioValue);

            // comision
            System.out.println("Comision es ");
            short comisionValue = (short) Short.parseShort(Menu.leerString());
            // set fecha egreso
            e.setComision(comisionValue);

            empleadoDAO.updateData(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void gestionDepto() {
        try {
            verDatos("Departamento");

            // opciones ACME
            Menu.tituloMenuACME();
            System.out.println("Seleccione Opcion: ");
            String opcionCRUD = Menu.leerString().toUpperCase();

            System.out.println("Mostrando las Columnas de la Tabla");
            DepartamentoDAO departamentoDAO = new DepartamentoDAO();
            // obteniendo la lista de columnas que puedo trabajar
//            Departamento d = departamentoDAO.getByIDData(idDeptoValue);
//            String[] tableColumn = departamentoDAO.getTableColumns();
//            for (String s : tableColumn) {
//                System.out.println(s.toString());
//            }
//            System.out.println("Seleccione Dato a " + tituloCRUD(opcionCRUD) + ": ");
//            String opcionCampo = Menu.leerString();
            String[] tableColumn = departamentoDAO.getTableColumns();
            ArrayList<String> sValorIn = new ArrayList<String>();
            Departamento nuevoDpto = new Departamento();

            switch (opcionCRUD) {
                case "C":
                    //Departamento d = departamentoDAO.getByIDData("101");

                    for (String d : tableColumn) {
                        System.out.println(d);
                        sValorIn.add(Menu.leerString());
                    }
                    // int iddepartamento, String nombre, String idubicacion
                    Departamento dNew = new Departamento(Integer.parseInt(sValorIn.get(0)), sValorIn.get(1), sValorIn.get(2));
                    departamentoDAO.insertData(dNew);

                    break;

                case "L":
                    verDatos("Departamento");
                    break;
                case "A":
                    verDatos("Departamento");
                    System.out.println("Seleccione el registro a modificar: ");
                    String codigo = Menu.leerString();
                    nuevoDpto = departamentoDAO.getByIDData(codigo);

                    // la columna a modificar
                    // int i = 0;
                    System.out.println("Seleccione Campo: ");
                    for (String d : tableColumn) {
                        System.out.println("\t\t\t " + d);
                    }
                    String valor = Menu.leerString();
                    System.out.println("Ingrese el valor de (" + valor + ": )");
                    String valorUpdate = Menu.leerString();

                    // haciendo el update para cada uno de los campos
                    switch (valor) {
                        case "iddepartamento":
                            nuevoDpto.setIddepartamento(Integer.parseInt(valorUpdate));
                            break;
                        case "nombre":
                            nuevoDpto.setNombre(valorUpdate);
                            break;
                        case "idubicacion":
                            nuevoDpto.setIdubicacion(valorUpdate);
                            break;
                        default:
                            break;
                    }

                    departamentoDAO.updateData(nuevoDpto);

                    // recuperando 
                    // procesarACTUALIZAR("Departamento", opcionCampo, opcionValor);
                    break;

                case "E":
                    verDatos("Departamento");
                    System.out.println("Seleccione el registro a modificar: ");
                    String codigoEliminar = Menu.leerString();
                    departamentoDAO.deleteData(codigoEliminar);
                    verDatos("Departamento");
                    break;
                default:
                    break;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static String tituloCRUD(String opcion) {
        String txt = "";
        switch (opcion) {
            case "C":
                txt = "crear";
                break;
            case "R":
                txt = "leer";
                break;
            case "U":
                txt = "actualizar";
                break;
            case "D":
                txt = "eliminar";
                break;
        }
        return txt;
    }

    static void gestionUsuario() throws HashGenerationException {
        try {
            verDatos("Usuario");
            // opciones ACME
            Menu.tituloMenuACME();
            System.out.println("Seleccione Opcion: ");
            String opcionCRUD = Menu.leerString().toUpperCase();

            System.out.println("Mostrando las Columnas de la Tabla");
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            String[] tableColumn = usuarioDAO.getTableColumns();
            ArrayList<String> sValorIn = new ArrayList<String>();
            Usuario nuevoUsuario = new Usuario();

            switch (opcionCRUD) {
                case "C":
                    for (String d : tableColumn) {
                        System.out.println(d);
                        sValorIn.add(Menu.leerString());
                    }
                    // String idempleado, String usuario, String clave, int estado, String rol
                    Usuario uNew = new Usuario(sValorIn.get(0).toUpperCase(), sValorIn.get(1), HashGeneratorUtils.generateSHA1(sValorIn.get(2)), Integer.parseInt(sValorIn.get(3)), sValorIn.get(4));
                    usuarioDAO.insertData(uNew);
                    break;
                case "L":
                    verDatos("Usuario");
                    break;
                case "A":
                    verDatos("Usuario");
                    System.out.println("Seleccione el registro a modificar: ");
                    String codigo = Menu.leerString();
                    nuevoUsuario = usuarioDAO.getByIDData(codigo);
                    System.out.println("Seleccione Campo: ");
                    for (String d : tableColumn) {
                        System.out.println("\t\t\t " + d);
                    }
                    // la columna a modificar
                    String valor = Menu.leerString();
                    System.out.println("Ingrese el valor de (" + valor + ": )");
                    String valorUpdate = Menu.leerString();

                    // haciendo el update para cada uno de los campos
                    switch (valor) {
                        case "idempleado":
                            nuevoUsuario.setIdempleado(valorUpdate);
                            break;
                        case "usuario":
                            nuevoUsuario.setUsuario(valorUpdate);
                            break;
                        case "clave":
                            nuevoUsuario.setClave(valorUpdate);
                            break;
                        case "estado":
                            nuevoUsuario.setEstado(Integer.parseInt(valorUpdate));
                            break;
                        case "rol":
                            nuevoUsuario.setRol(valorUpdate);
                            break;
                        default:
                            break;
                    }
                    usuarioDAO.updateData(nuevoUsuario);
                    break;
                case "E":
                    verDatos("Usuario");
                    System.out.println("Seleccione el registro a modificar: ");
                    String codigoEliminar = Menu.leerString();
                    usuarioDAO.deleteData(codigoEliminar);
                    verDatos("Usuario");

                    break;
                default:
                    break;
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppServices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
