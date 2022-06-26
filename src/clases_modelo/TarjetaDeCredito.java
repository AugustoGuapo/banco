/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class TarjetaDeCredito {
    private int ID;
    private String numeroDeTarjeta;
    private LocalDate fechaDeVencimiento;
    private String CVV;
    private float montoTotal;
    private float montoAdeudado;
    private int nroCuotasAdeudadas;
    private int nroCuotasPagadas;
    private String estado;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the numeroDeTarjeta
     */
    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    /**
     * @param numeroDeTarjeta the numeroDeTarjeta to set
     */
    public void setNumeroDeTarjeta(String numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    /**
     * @return the fechaDeVencimiento
     */
    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    /**
     * @param fechaDeVencimiento the fechaDeVencimiento to set
     */
    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    /**
     * @return the CVV
     */
    public String getCVV() {
        return CVV;
    }

    /**
     * @param CVV the CVV to set
     */
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    /**
     * @return the montoTotal
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * @return the montoAdeudado
     */
    public float getMontoAdeudado() {
        return montoAdeudado;
    }

    /**
     * @param montoAdeudado the montoAdeudado to set
     */
    public void setMontoAdeudado(float montoAdeudado) {
        this.montoAdeudado = montoAdeudado;
    }

    /**
     * @return the nroCuotasAdeudadas
     */
    public int getNroCuotasAdeudadas() {
        return nroCuotasAdeudadas;
    }

    /**
     * @param nroCuotasAdeudadas the nroCuotasAdeudadas to set
     */
    public void setNroCuotasAdeudadas(int nroCuotasAdeudadas) {
        this.nroCuotasAdeudadas = nroCuotasAdeudadas;
    }

    /**
     * @return the nroCuotasPagadas
     */
    public int getNroCuotasPagadas() {
        return nroCuotasPagadas;
    }

    /**
     * @param nroCuotasPagadas the nroCuotasPagadas to set
     */
    public void setNroCuotasPagadas(int nroCuotasPagadas) {
        this.nroCuotasPagadas = nroCuotasPagadas;
    }
    
        public boolean solicitud() {
        return true;
    }
    
    public float calcularCuotas(int nroCuotas) {
        float cuota = (float) (montoAdeudado*(nroCuotas*2.2875))/nroCuotas;
        return cuota;
    }
    
    public void pagoCuota(float monto) {
        montoAdeudado-=monto;
    }
    
    private int contarTDCs(TarjetaDeCredito[] arreglo, String id) {
        int salida=0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getID() == ID)
                salida++;
        }
        return salida;
    }
    
    public int[] buscarTDCs(TarjetaDeCredito[] arreglo, String id) {
        int[] posiciones = new int[contarTDCs(arreglo, id)];
        int posicion=0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].getID() == ID) {
                posiciones[posicion]=i;
                posicion++;
            }  
        }
        return posiciones;
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
}
