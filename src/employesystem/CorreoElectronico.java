/*
 * Implemento uso de ConfigProperties
 * Implemento Encriptacion de Credenciales
 * Autenticacion por Token
 * 
 */
package employesystem;

import com.cvasquez.properties.ConfigProperties;
import com.cvasquez.utilidades.EncriptacionTexto;
import com.sun.security.auth.login.ConfigFile;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Cvasquez
 */
public class CorreoElectronico {

    private static final String FILE_LANGUAGE_PROPERTIES = "config.properties";
    // private static final String DEFAULT_LANGUAGE = "ES";

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) throws IOException {
//        // TODO code application logic here
//        // creando nueva persona Solo para metodo de Autenticacion.
//        Persona persona = new Persona();
//
//        // load properties
//        Properties prop = new Properties();
//        Properties propLanguage = new Properties();
//        String fileName = "config.properties";
//        prop.load(ConfigProperties.getResourceAsInputStrings(fileName));
//        System.out.println("**********");
//        propLanguage.load(ConfigProperties.getResourceAsInputStrings(FILE_LANGUAGE_PROPERTIES));
//        System.out.println(prop.get("applicationName"));
//
//        // creando menu
//        Menu menu = new Menu();
//        // creando historial de session
//        List list = new ArrayList();
//        // capturando fecha del sistema y convierto a un formato especifico
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        list.add("Login " + dtf.format(now));
//        // notificando autenticacion por Token al email del usuario
//        boolean banderaAut = metodoAutenticacionEmail(prop, persona);
//        if (banderaAut) {
//            try {
//                menu.init(list, persona, prop);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(CorreoElectronico.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

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

    private static boolean metodoAutenticacionEmail(Properties prop, Persona persona) {
        // cargando las propiedades del fichero de configuracion

        Scanner scanner = new Scanner(System.in);

        System.out.println("Metodo Envio de Correo electronico");

        // capturando informacion de Persona desde teclado
        System.out.println("Ingrese Nombre de Usuario");
        String nombreUsuario = scanner.nextLine();
        System.out.println("Ingrese direccion de Correo Electronico");
        String correoUsuario = scanner.nextLine();
        // guardando los datos ingresados por consola
        persona.setNombreUsuario(nombreUsuario);
        persona.setEmail(correoUsuario);

        // Genero un numero random como clave secreta
        Random rand = new Random();
        String textoDescripcion = "Codigo de Confirmacion es: ";
        String codigoConfirmacion = "" + rand.nextInt(10000);

        // enviando correo con codigoSecreto
        enviarCorreoElectronico(persona, textoDescripcion + codigoConfirmacion, prop);

        // comprobando el codigo enviado al correo
        // Validacion CODIGO ingresado desde teclado es el mismo que se envio al correo
        boolean banderaEmail = true;
        boolean banderaAutIN = false;
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

        return banderaAutIN;
    }

}
