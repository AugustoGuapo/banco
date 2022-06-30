/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Clientes {
    private int ID;
    private String nombre;
    private String numeroDeDocumento;
    private LocalDate fechaDeNacimiento;
    private String correoElectronico;
    private String numeroTelefono;
    private String sexo;
    private String estado;
    private Credenciales credenciales;
    private ArrayList<Object> productos = new ArrayList();

    public Clientes() {
        credenciales = new Credenciales();
    }
    /**
     * @return the systemID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the systemID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the numeroDeDocumento
     */
    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    /**
     * @param numeroDeDocumento the numeroDeDocumento to set
     */
    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    /**
     * @return the fechaDeNacimiento
     */
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    /**
     * @param fechaDeNacimiento the fechaDeNacimiento to set
     */
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the numeroTelefono
     */
    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    /**
     * @param numeroTelefono the numeroTelefono to set
     */
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the credenciales
     */
    public Credenciales getCredenciales() {
        return credenciales;
    }

    /**
     * @param credenciales the credenciales to set
     */
    public void setCredenciales(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    /**
     * @return the productos at 
     * @param pos
     */
    public Object getProductos(int pos) {
        return productos.get(pos);
    }

    /**
     * @param productos the productos to set
     */
    public void añadirProductos(Object productos) {
        this.productos.add(productos);
    }
    
    public int cantidadDeProductos() {
        return productos.size();
    }
    
}
