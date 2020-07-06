/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.entidades;

/**
 *
 * @author NewBie
 */
public class Ubicacion {

    private String idubicacion;
    private String ciudad;
    private String direccion;

    public Ubicacion(String idubicacion, String ciudad, String direccion) {
        this.idubicacion = idubicacion;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Ubicacion() {
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + "idubicacion" + idubicacion + "ciudad" + ciudad + "direccion" + direccion + '}';
    }
}
