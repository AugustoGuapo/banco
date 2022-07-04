/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

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
    private float valorCuota;
    private String estado;
    private LocalDate fechaProximoPago;

    public String getFechaProximoPago(String label) {
        if(fechaProximoPago != null)
            return fechaProximoPago.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        return "---";
    }
    
    public LocalDate getFechaProximoPago() {
        return fechaProximoPago;
    }
    
    public void setFechaProximoPago(LocalDate fecha) {
        fechaProximoPago = fecha;
    }
    
    
    public float getValorCuota() {
        return valorCuota;
    }
    
    public void setValorCuota(int nroCuotas) {
        valorCuota=calcularCuotas(nroCuotas);
    } 
    
    
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
        this.montoAdeudado = (float) (montoAdeudado*1.225);
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
     
    public float calcularCuotas(int nroCuotas) {
        float cuota = (float) (montoAdeudado)/nroCuotas;
        return cuota;
    }
    
    public void pagoCuota(float monto) {
        montoAdeudado-=monto;
        nroCuotasAdeudadas-=1;
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
    
    public void generarNumeroTarjeta() {
        String salida="";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            if(i!=0)
                salida+=" ";
            for (int j = 0; j < 4; j++) {
                salida+= String.valueOf(random.nextInt(9));
            }
        }
        numeroDeTarjeta = salida;
    }
    
    public void generarCVV() {
        String salida ="";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            salida = String.valueOf(random.nextInt(9));
        }
        CVV=salida;
    }
}
