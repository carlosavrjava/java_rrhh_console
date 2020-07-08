/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.entidades;

import sv.echo.bitlab.dao.AbstractDAO;

/**
 *
 * @author NewBie
 */
public class View {

    private String idempleado;
    private String apellido;
    private String nombre;
    private int sueldo;
    private int comision;
    private int total;
    private Double afp;
    private Double isss;

    public View(String idempleado, String apellido, String nombre, int sueldo, int comision, int total, Double afp, Double isss) {
        this.idempleado = idempleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.comision = comision;
        this.total = total;
        this.afp = afp;
        this.isss = isss;
    }

    public View(){
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Double getAfp() {
        return afp;
    }

    public void setAfp(Double afp) {
        this.afp = afp;
    }

    public Double getIsss() {
        return isss;
    }

    public void setIsss(Double isss) {
        this.isss = isss;
    }

    @Override
    public String toString() {
        return "Planilla { "
                + "idempleado"
                + idempleado
                + "apellido"
                + apellido
                + "nombre"
                + nombre
                + "sueldo"
                + sueldo
                + "comision"
                + comision
                + "total"
                + total
                + "afp"
                + afp
                + "isss"
                + isss
                + '}';
    }

    public String toTableView() {
        return "| "
                + " | "
                + idempleado
                + " | "
                + apellido
                + " | "
                + nombre
                + " | "
                + sueldo
                + " | "
                + comision
                + " | "
                + total
                + " | "
                + afp
                + " | "
                + isss
                + " |";
    }

}
