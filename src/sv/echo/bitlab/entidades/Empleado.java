/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.echo.bitlab.entidades;

import java.sql.Date;

/**
 *
 * @author NewBie
 */
public class Empleado {

    private String idempleado;
    private String apellido;
    private String nombre;
    private Date fecingreso;
    private String email;
    private String telefono;
    private String idcargo;
    private int iddepartamento;
    private int sueldo;
    private int comision;
    private String jefe;

    public Empleado(String idempleado, String apellido, String nombre, Date fecingreso, String email, String telefono, String idcargo, int iddepartamento, int sueldo, int comision, String jefe) {
        this.idempleado = idempleado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fecingreso = fecingreso;
        this.email = email;
        this.telefono = telefono;
        this.idcargo = idcargo;
        this.iddepartamento = iddepartamento;
        this.sueldo = sueldo;
        this.comision = comision;
        this.jefe = jefe;
    }

    public Empleado() {
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

    public Date getFecingreso() {
        return fecingreso;
    }

    public void setFecingreso(Date fecingreso) {
        this.fecingreso = fecingreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(String idcargo) {
        this.idcargo = idcargo;
    }

    public int getIddepartamento() {
        return iddepartamento;
    }

    public void setIddepartamento(int iddepartamento) {
        this.iddepartamento = iddepartamento;
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

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    @Override
    public String toString() {
        return "Empleado{" + " idempleado =" + idempleado + ", apellido =" + apellido + ", nombre =" + nombre + ", fecingreso =" + fecingreso + ", email =" + email + ", telefono =" + telefono + ", idcargo =" + idcargo + ", iddepartamento =" + iddepartamento + ", sueldo =" + sueldo + ", comision =" + comision + ", jefe =" + jefe + '}';
    }
}
