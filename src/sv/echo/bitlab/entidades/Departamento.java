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
public class Departamento {

    private int iddepartamento;
    private String nombre;
    private String idubicacion;

    public Departamento(int iddepartamento, String nombre, String idubicacion) {
        this.iddepartamento = iddepartamento;
        this.nombre = nombre;
        this.idubicacion = idubicacion;
    }

    public Departamento() {
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdubicacion() {
        return idubicacion;
    }

    public void setIdubicacion(String idubicacion) {
        this.idubicacion = idubicacion;
    }
    @Override
    public String toString() {
        return "Departamento{" + "iddepartamento" + iddepartamento + "nombre" + nombre + "idubicacion" + idubicacion  + '}';
    }
}
