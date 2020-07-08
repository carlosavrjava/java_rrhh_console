/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.codejava.security.HashGenerationException;

/**
 *
 * @author NewBie
 */
public class Menu {

    public String initRRHH(List list, Persona persona, Properties prop) throws InterruptedException, SQLException, HashGenerationException {
        Scanner scanner = new Scanner(System.in);
        Short timeSleep = 1;
        Short opcion = 0;

        String element = "";
        Properties p = System.getProperties();

        if (persona.getRol().toUpperCase().equals("ADMIN")) {
            titulosMenuAdmin();
        } else if (persona.getRol().toUpperCase().equals("RRHH")) {
            titulosMenuRRHH();
        }

        do {
            // capturando fecha del sistema y convierto a un formato especifico

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            // validando las opciones disponibles segun el rol del usuario del app

            if (persona.getRol().toUpperCase().equals("ADMIN")) {
                opcion = this.leerOpcion(19, 50);
            } else if (persona.getRol().toUpperCase().equals("RRHH")) {
                opcion = this.leerOpcion(1, 17);
            }

            System.out.println("Opcion: " + opcion);
            switch (opcion) {
                case 1:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.verDatos("Empleado");
                    break;
                case 10:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);

                    break;
                case 11:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    // AppServices.verDatos("Empleado");
                    AppServices.desactivarEmpleado();
                    break;
                case 12:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.agregarEmpleado();
                    break;
                case 13:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    //AppServices.verDatos("Departamento");
                    AppServices.actualizarDepto();
                    break;
                case 14:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.actualizarJefe();
                    break;
                case 15:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.actualizarSalario();
                    break;
                case 16:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.verDatos("HISTORIAL");

                    break;
                case 17:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    System.out.println("Generación de pagos en planilla");
                    AppServices.verDatos("Planilla");
                    break;

                case 20:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.gestionDepto();
                    break;
                case 21:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    break;                    
                case 22:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);
                    AppServices.gestionUsuario();

                    break;
                case 23:
                    // para auditoria de las acciones realizadas por el usuario
                    element = dtf.format(now) + " " + persona.getRol() + " " + persona.getNombreUsuario() + " opcion menu: " + opcion;
                    list.add(element);

                    break;

                case 5:
                case 50:
                    boolean flagExit = true;
                    while (flagExit) {
                        System.out.println("Desea Terminar Sesion Y/N");
                        String salir = scanner.nextLine();
                        if ("Y".equalsIgnoreCase(salir)) {
                            String textoDescripcion = "Lista de acciones realizadas durante su ultima Session " + dtf.format(now) + "\n\n";
                            CorreoElectronico.enviarCorreoElectronico(persona, textoDescripcion + list.toString().replace(",", "\n"), prop);
                            flagExit = false;
                            opcion = 5;
                            System.out.println("SALIENDO...");
                        } else if ("N".equalsIgnoreCase(salir)) {
                            flagExit = false;
                            opcion = 0;
                        } else {
                            flagExit = true;
                        }
                    }
                    break;
            }
        } while (opcion != 5);
        return null;
    }

    public String init(List list, Persona persona, Properties prop) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Short timeSleep = 1;
        Short opcion = 0;
        Short alturaPiramide = 0;
        String element = "";
        Properties p = System.getProperties();
//        Iterator iter = list.iterator();
        titulosMenu();
        do {
            // capturando fecha del sistema y convierto a un formato especifico
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            // list.add("Login " + dtf.format(now));
            try {
                // opcion = Short.parseShort(scanner.nextLine());
                titulosMenu();

                opcion = this.leerOpcion(1, 100);
                System.out.println("Opcion: " + opcion);
                switch (opcion) {
                    case 10:
                        element = "10 Informacion del Sistema Operativo";
                        list.add(element + dtf.format(now));
                        System.out.println("Propiedades del Sistema Operativo");
                        System.out.println("Nombre del sistema operativo " + p.getProperty("os.name")); //property to get Operating system name
                        System.out.println("Arquitectura del sistema operativo " + p.getProperty("os.arch")); //property to get Operating system architecture
                        System.out.println("Versión del sistema operativo " + p.getProperty("os.version")); //property to get Operating system version
                        break;

                    case 15:
                        element = "15 Propiedades del Usuario Actual";
                        list.add(element + dtf.format(now));
                        System.out.println("Nombre de cuenta del usuario " + p.getProperty("user.name")); //property to get User's account name
                        System.out.println("Directorio de inicio del usuario " + p.getProperty("user.home")); //property to get User's home directory
                        System.out.println("Directorio de trabajo actual del usuario S" + p.getProperty("user.dir")); //property to get User's current working directory
                        break;

                    case 20:
                        element = "20 Listar las Propiedades Actuales del Sistema";
                        list.add(element + dtf.format(now));
                        p.list(System.out);
                        break;

                    case 25:
                        element = "25 Directorio Temporal Local";
                        list.add(element + dtf.format(now));
                        String s = System.getProperty("java.io.tmpdir");
                        System.out.println(s);
                        break;
                    case 30:
                        element = "30 Crear Directorio en Carpeta Actual";
                        // list.add(element + dtf.format(now));
                        // File file = new File(p.getProperty("user.dir") + p.getProperty("file.separator") + "source.txt");
                        // File dir = new File(p.getProperty("user.dir") + p.getProperty("file.separator") + "directorio");
                        createFileUsingFileClass(list, "source.txt");

                        // System.out.println("Se creo: source.txt?" + file.isFile());
                        // System.out.println("Se creo: directorio?" + dir.isDirectory());
                        System.out.println("Directorio actual de trabajo " + p.getProperty("user.dir") + p.getProperty("file.separator"));
                        break;
                    case 35:
                        element = "35 Crear Registros y Escribir mis observaciones";
                        list.add(element + dtf.format(now));
                        createFileUsingFileClass(list, "testFile1.txt");
                        break;
                    case 40:
                        element = "40 Copiando Archivos output a HOME desde Temp";
                        list.add(element + dtf.format(now));
                        System.out.println(p.getProperty("user.dir") + p.getProperty("file.separator"));
                        System.out.println(System.getProperty("java.io.tmpdir"));
                        //Source directory which you want to copy to new location
                        // File sourceFolder = new File("c:\\temp");
                        File sourceFolder = new File(System.getProperty("java.io.tmpdir") + "RESPALDO_TAREA03" + p.getProperty("file.separator"));
                        //Target directory where files should be copied
                        // File destinationFolder = new File("c:\\tempNew");
                        File destinationFolder = new File(p.getProperty("user.dir") + p.getProperty("file.separator") + "RESPALDO_TAREA_BAK" + p.getProperty("file.separator"));

                        //Call Copy function
                        copyFolder(sourceFolder, destinationFolder);
                        break;
                    case 5:
                        boolean flagExit = true;
                        while (flagExit) {
                            System.out.println("Desea Terminar Sesion Y/N");
                            String salir = scanner.nextLine();
                            if ("Y".equalsIgnoreCase(salir)) {
                                String textoDescripcion = "Lista de acciones realizadas durante su ultima Session " + dtf.format(now) + "\n\n";
                                CorreoElectronico.enviarCorreoElectronico(persona, textoDescripcion + list.toString().replace(",", "\n"), prop);
                                flagExit = false;
                                opcion = 5;
                                System.out.println("SALIENDO...");
                            } else if ("N".equalsIgnoreCase(salir)) {
                                flagExit = false;
                                opcion = 0;
                            } else {
                                flagExit = true;
                            }
                        }
                        break;

                }
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 5);
        return null;
    }

    public static String leerId() {
        String var = "";
        boolean bandera = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.format("Respuesta(Primera Columna)= ");
            try {
                var = scanner.nextLine();
                if (!(var.isEmpty()) && !(var.isBlank())) {
                    bandera = false;
                }
            } catch (NumberFormatException e) {
                System.out.format("Ingrese codigo valido()");
            }
        } while (bandera);

        return var.toString().toUpperCase();
    }

    // 
    public static String leerString() {
        String var = "";
        boolean bandera = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.format("Respuesta =");
            try {
                var = scanner.nextLine();
                if (!(var.isEmpty()) && !(var.isBlank())) {
                    bandera = false;
                }
            } catch (NumberFormatException e) {
                System.out.format("Ingrese dato Valido");
            }
        } while (bandera);

        return var.toString().toLowerCase(Locale.US);
    }

    //
    public static short leerOpcion(int i, int j) {
        short var = 0;
        boolean bandera = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.format("Respuesta(%d - %d)= ", i, j);
            try {
                var = Short.parseShort(scanner.nextLine());
                if (var >= i && var <= j) {
                    bandera = false;
                }
            } catch (NumberFormatException e) {
                System.out.format("Ingrese un valor entre (%d - %d)", i, j);
            }
        } while (bandera);

        return var;
    }

    private void createFileUsingFileClass(List list, String nameFile) throws IOException {
        //System.getProperty("java.io.tmpdir")
        File file = new File(System.getProperty("java.io.tmpdir") + nameFile);

        //Create the file
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }

        //Write Content
        FileWriter writer = new FileWriter(file);
        // writer.write("Test data");
        writer.write(list.toString());
        writer.close();
    }

    private static void copyFolder(File sourceFolder, File destinationFolder) throws IOException {
        //Check if sourceFolder is a directory or file
        //If sourceFolder is file; then copy the file directly to new location
        if (sourceFolder.isDirectory()) {
            //Verify if destinationFolder is already present; If not then create it
            if (!destinationFolder.exists()) {
                destinationFolder.mkdir();
                System.out.println("Directory created :: " + destinationFolder);
            }

            //Get all files from source directory
            // String files[] = sourceFolder.list();
            String files[] = sourceFolder.list();

            //Iterate over all files and copy them to destinationFolder one by one
            for (String file : files) {
                File srcFile = new File(sourceFolder, file);
                File destFile = new File(destinationFolder, file);

                //Recursive function call
                copyFolder(srcFile, destFile);
            }
        } else {
            //Copy the file content from one place to another 
            Files.copy(sourceFolder.toPath(), destinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied :: " + destinationFolder);
        }
    }
// eliminar no los utilizo en este codigo

    private void titulosMenu() {
        System.out.println("");
        System.out.println("\f MENU PRINCIPAL (Seleccione Opcion)");
        System.out.println("\t->10 Informacion del Sistema Operativo");
        System.out.println("\t->15 Propiedades del Usuario Actual");
        System.out.println("\t->20 Listar las Propiedades Actuales del Sistema");
        System.out.println("\t->25 Directorio Local Temporal");
        System.out.println("\t->30 Crear Directorio en Carpeta Actual");
        System.out.println("\t->35 Crear Registros y Escribir mis observaciones");
        System.out.println("\t->40 Copiando Archivos output a HOME desde Temp");
        System.out.println("5 - Salir");
        System.out.println("");
    }

    // para cada rol existe un menu 
    // ambos rol son excluyentes
    private void titulosMenuRRHH() {
        System.out.println("");
        System.out.println("\f MENU PRINCIPAL RRHH (Seleccione Opcion)");
        System.out.println("\t->1 ver Lista de Empleados.");
        System.out.println("\t->10 Actualización de datos del empleado.");
        System.out.println("\t->11 Desactivación de empleados por despido.");
        System.out.println("\t->12 Contratación de empleados.");
        System.out.println("\t->13 Asignación de departamento.");
        System.out.println("\t->14 Asignación de Jefaturas.");
        System.out.println("\t->15 Actualización de salario mensual.");
        System.out.println("\t->16 Visualización de pagos generados.");
        System.out.println("\t->17 Generación de pagos en planilla.");
        System.out.println("\t");
        System.out.println("\t-> 5 EXIT");
    }

    private void titulosMenuAdmin() {
        System.out.println("");
        System.out.println("\f MENU PRINCIPAL ADMIN (Seleccione Opcion)");
        System.out.println("\t->20 Gestión de departamentos.");
        System.out.println("\t->21 Gestión de estados de empleados.");
        System.out.println("\t->22 Gestión de usuarios.");
        System.out.println("\t->23 Gestión de Roles.");
        System.out.println("\t");
        System.out.println("\t-> 50 EXIT");
    }
    
    public static void  tituloMenuACME(){
        System.out.println("");
        System.out.println("\t ->C CREAR");
        System.out.println("\t ->L LEER");
        System.out.println("\t ->A ACTUALIZAR");
        System.out.println("\t ->E ELIMINAR");
    }

}
