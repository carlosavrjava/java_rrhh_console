/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employesystem;

import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.echo.bitlab.dao.*;
import sv.echo.bitlab.entidades.*;
import com.cvasquez.properties.ConfigProperties;
import com.cvasquez.utilidades.EncriptacionTexto;
import com.sun.security.auth.login.ConfigFile;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import org.apache.commons.mail.*;
import net.codejava.security.*;

/**
 *
 * @author cVasquez
 */
public class RRHHSystem {

    //Se deberá parametrizar y encriptar
    private static Logger log = Logger.getLogger(RRHHSystem.class.getName());
    private static final String FILE_LANGUAGE_PROPERTIES = "config.properties";
    // private static final String DEFAULT_LANGUAGE = "ES";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        try {
            // creando nueva persona Solo para metodo de Autenticacion.
            // Esta es la persona / Usuario que esta logueado en este momento.
            // de la tabla usuario
            Persona persona = new Persona();

            // load properties
            Properties prop = new Properties();
            Properties propLanguage = new Properties();
            String fileName = "config.properties";
            prop.load(ConfigProperties.getResourceAsInputStrings(fileName));
            System.out.println("**********");
            propLanguage.load(ConfigProperties.getResourceAsInputStrings(FILE_LANGUAGE_PROPERTIES));
            System.out.println(prop.get("applicationName"));
            // creando menu
            Menu menu = new Menu();
            // creando historial de session
            List list = new ArrayList();
            // capturando fecha del sistema y convierto a un formato especifico
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            list.add("Login " + dtf.format(now));
            // notificando autenticacion por Token al email del usuario
            boolean banderaAut = metodoAutenticacionEmail(prop, persona);
            // pido validacion por doble autenticacion si hay exito pinto menu del app

            if (banderaAut) {
                try {

                    menu.initRRHH(list, persona, prop);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CorreoElectronico.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();;
        }

    }

    public static void enviarCorreoElectronico(Persona persona, String contenidoEmail, Properties prop) {
        //System.out.println(prop.get("language"));
        Email email = new SimpleEmail();
        EncriptacionTexto encritacionTexto = new EncriptacionTexto();
        try {
            //email.setHostName("smtp.gmail.com");
            email.setHostName(encritacionTexto.getTextoDesencriptado(prop.getProperty("srEmName")));
            //email.setSmtpPort(465);
            email.setSmtpPort(465);
            //email.setAuthentication("carlosavr.java@gmail.com", "8hCP2NLEyHh3wes");
            email.setAuthentication(
                    encritacionTexto.getTextoDesencriptado(prop.getProperty("srEmU")),
                    encritacionTexto.getTextoDesencriptado(prop.getProperty("srEmP")));
            email.setSSLOnConnect(true);
            email.setFrom(encritacionTexto.getTextoDesencriptado(prop.getProperty("srEmFrom")));
            // email.setFrom("user@gmail.com");
            email.setSubject(encritacionTexto.getTextoDesencriptado(prop.getProperty("tituloE")));
            //email.setSubject("TestMail");
            email.setMsg(encritacionTexto.getTextoDesencriptado(prop.getProperty("textoE")) + "\nDescripcion: " + contenidoEmail + "\n Gracias por confirmar \n" + persona.getNombreUsuario() + " \n\n Feliz Dia");
            email.addTo(persona.getEmail());
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(CorreoElectronico.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static boolean metodoAutenticacionEmail(Properties prop, Persona persona) throws SQLException, HashGenerationException {
        // creando la coneccion a base de datos para ver si el usuario existe
        boolean banderaEmail = true;
        boolean banderaAutIN = false;
        boolean banderaExistUserDB = false;
        boolean banderaExistClaveDB = false;
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            List<Usuario> usuario;
            usuario = usuarioDAO.getAllData();

            //
            // cargando las propiedades del fichero de configuracion
            Scanner scanner = new Scanner(System.in);

            System.out.println("Metodo Envio de Correo electronico");

            // capturando informacion de Persona desde teclado
            System.out.println("Ingrese Usuario (EXXXX)");
            String nombreUsuario = scanner.nextLine();
            System.out.println("Ingrese Contraseña Usuario");
            String contrasenaTemp = scanner.nextLine();
            // System.out.println("Ingrese Direccion de Correo Electronico");
            //String correoUsuario = scanner.nextLine();

            // recupero el email almacenado en la base de datos
            String correoUsuario = "";

            // guardando los datos ingresados por consola
            persona.setNombreUsuario(nombreUsuario);
            persona.setEmail(correoUsuario);
            persona.setContrasenaUsuario(contrasenaTemp);

            // verifico si existe el usuario en la base de datos
            for (Usuario u : usuario) {
                // System.out.println(e.getIdempleado());
                if (nombreUsuario.toUpperCase().equals(u.getIdempleado()) || nombreUsuario.equals(u.getUsuario())) {
                    banderaExistUserDB = true;
                    String sha1Hash = HashGeneratorUtils.generateSHA1(contrasenaTemp);
                    // System.out.println("SHA-1 Hash: " + sha1Hash);
                    if (sha1Hash.equals(u.getClave())) {
                        banderaExistClaveDB = true;
                        persona.setRol(u.getRol());
                        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                        Empleado e = empleadoDAO.getByIDData(u.getIdempleado());
                        persona.setEmail(e.getEmail());
                    } else {
                        banderaExistClaveDB = false;
                    }
                    // if(persona.getContrasenaUsuario().equals(.get))
                    break;
                } else {
                    banderaExistUserDB = false;
                }
                // log.info(e.toString());
            }

            if (banderaExistUserDB) {
                System.out.println("encontre al usuario en la base");
                if (banderaExistClaveDB) {
                    System.out.println("Los Datos son Correctos Valide codigo enviado a Email");
                } else {
                    System.out.println("El usuario es correcto, la contraseña es erronea.");
                    System.exit(0);
                }
            } else {
                System.out.println("Usuario No Registrado en App");
                System.exit(0);
            }

            // Genero un numero random como clave secreta
            Random rand = new Random();
            String textoDescripcion = "Codigo de Confirmacion es: ";
            String codigoConfirmacion = "" + rand.nextInt(10000);

            // enviando correo con codigoSecreto
            enviarCorreoElectronico(persona, textoDescripcion + codigoConfirmacion, prop);

            // comprobando el codigo enviado al correo
            // Validacion CODIGO ingresado desde teclado es el mismo que se envio al correo
            short contadorOut = 1;
            do {
                System.out.println("Ingrese su codigo Secreto: ");
                String respCodigo = scanner.nextLine();
                if (codigoConfirmacion.equals(respCodigo)) {
                    System.out.println("Bienvenido AppJava... Ejecutando Menu...");
                    banderaEmail = false;
                    banderaAutIN = true;
                } else if (contadorOut < 5) {
                    System.out.println("Codigo No valido, Revise su correo...");
                    contadorOut += contadorOut;
                } else {
                    System.out.println("Numero de intentos alcanzado. Contacte con Soporte Tecnico");
                    banderaAutIN = false;
                    banderaEmail = false;
                    break;
                }
            } while (banderaEmail);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RRHHSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return banderaAutIN;

    }

}
