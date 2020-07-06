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
public class Cargo {

    private String idcargo;
    private String nombre;
    private int sueldo_min;
    private int sueldo_max;

    public Cargo(String idcargo, String nombre, int sueldo_min, int sueldo_max) {
        this.idcargo = idcargo;
        this.nombre = nombre;
        this.sueldo_min = sueldo_min;
        this.sueldo_max = sueldo_max;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo_min() {
        return sueldo_min;
    }

    public void setSueldo_min(int sueldo_min) {
        this.sueldo_min = sueldo_min;
    }

    public int getSueldo_max() {
        return sueldo_max;
    }

    public void setSueldo_max(int sueldo_max) {
        this.sueldo_max = sueldo_max;
    }

    @Override
    public String toString() {
        return "Cargo {"+ "idcargo" + idcargo + "nombre" + nombre + "sueldo_min" + sueldo_min + "sueldo_max" + sueldo_max + '}';
    }

}
