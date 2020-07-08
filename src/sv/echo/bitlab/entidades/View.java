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
    private String depto;
    private String cargo;
    private String apellido;
    private String nombre;
    private Double salario;
    private Double isss;
    private Double afp;
    private Double rentaGrabada;
    private Double rentaMensual;
    private Double salarioRecibido;

    public View() {
    }

    public View(String idempleado, String depto, String cargo, String apellido, String nombre, Double salario, Double isss, Double afp, Double rentaGrabada, Double rentaMensual, Double salarioRecibido) {
        this.idempleado = idempleado;
        this.depto = depto;
        this.cargo = cargo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.salario = salario;
        this.isss = isss;
        this.afp = afp;
        this.rentaGrabada = rentaGrabada;
        this.rentaMensual = rentaMensual;
        this.salarioRecibido = salarioRecibido;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Double getIsss() {
        return isss;
    }

    public void setIsss(Double isss) {
        this.isss = isss;
    }

    public Double getAfp() {
        return afp;
    }

    public void setAfp(Double afp) {
        this.afp = afp;
    }

    public Double getRentaGrabada() {
        return rentaGrabada;
    }

    public void setRentaGrabada(Double rentaGrabada) {
        this.rentaGrabada = rentaGrabada;
    }

    public Double getRentaMensual() {
        return rentaMensual;
    }

    public void setRentaMensual(Double rentaMensual) {
        this.rentaMensual = rentaMensual;
    }

    public Double getSalarioRecibido() {
        return salarioRecibido;
    }

    public void setSalarioRecibido(Double salarioRecibido) {
        this.salarioRecibido = salarioRecibido;
    }

    @Override
    public String toString() {
        return "Planilla { "
                + "idempleado: "
                + idempleado
                + "depto: "
                + depto
                + "cargo: "
                + cargo
                + "apellido: "
                + apellido
                + "nombre: "
                + nombre
                + "salario: "
                + salario
                + "isss: "
                + isss
                + "afp: "
                + afp
                + "rentaGrabada: "
                + rentaGrabada
                + "rentaMensual: "
                + rentaMensual
                + "salarioRecibido: "
                + salarioRecibido
                + '}';
    }

    public String toTableView() {
        return "| "
                + idempleado
                + " | "
                + depto
                + " | "
                + cargo
                + " | "
                + apellido
                + " | "
                + nombre
                + " | "
                + salario
                + " | "
                + isss
                + " | "
                + afp
                + " | "
                + rentaGrabada
                + " | "
                + rentaMensual
                + " | "
                + salarioRecibido
                + " |";
    }

}
