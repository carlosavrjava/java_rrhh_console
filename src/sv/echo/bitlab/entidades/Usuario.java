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
public class Usuario {

    private String idempleado;
    private String usuario;
    private String clave;
    private int estado;

    public Usuario(String idempleado, String usuario, String clave, int estado) {
        this.idempleado = idempleado;
        this.usuario = usuario;
        this.clave = clave;
        this.estado = estado;
    }

    public Usuario() {
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idempleado" + idempleado + "usuario" + usuario + "clave" + clave + "estado" + estado + '}';
    }
}
