/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author user
 */
public class Creditos {
    private int ID;
    private String tipoDeCredito;
    private float tasaDeInteres;
    private float monto;
    private int numeroDeCuotas;
    private int cuotasAdeudadas;
    private String estado;
    private LocalDate fechaProximoPago;
    private float valorCuota;
    
    
    public void calcularCuota() {
        valorCuota=monto/numeroDeCuotas;
    }
    
    public float getValorCuota() {
        return valorCuota;
    }
   public String getFechaProximoPago(String label) {
        if(fechaProximoPago != null)
            return fechaProximoPago.format(DateTimeFormatter.ofPattern("dd/MM/yy"));
        return "---";
    }
    
    public LocalDate getFechaProximoPago() {
        return fechaProximoPago;
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
     * @return the tipoDeCredito
     */
    public String getTipoDeCredito() {
        return tipoDeCredito;
    }

    /**
     * @param tipoDeCredito the tipoDeCredito to set
     */
    public void setTipoDeCredito(String tipoDeCredito) {
        this.tipoDeCredito = tipoDeCredito;
    }

    /**
     * @return the monto
     */
    public float getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(float monto) {
        this.monto = (float) (monto*1.225);
    }

    /**
     * @return the numeroDeCuotas
     */
    public int getNumeroDeCuotas() {
        return numeroDeCuotas;
    }

    /**
     * @param numeroDeCuotas the numeroDeCuotas to set
     */
    public void setNumeroDeCuotas(int numeroDeCuotas) {
        this.numeroDeCuotas = numeroDeCuotas;
    }

    /**
     * @return the cuotasAdeudadas
     */
    public int getCuotasAdeudadas() {
        return cuotasAdeudadas;
    }

    /**
     * @param cuotasAdeudadas the cuotasAdeudadas to set
     */
    public void setCuotasAdeudadas(int cuotasAdeudadas) {
        this.cuotasAdeudadas = cuotasAdeudadas;
    }

    /**
     * @return the estatusDeAprobación
     */
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado=estado;
    }
    
    public void pagoDeCuota(float monto) {
        this.monto-=monto;
    }

    /**
     * @return the tasaDeInteres
     */
    public float getTasaDeInteres() {
        return tasaDeInteres;
    }

    /**
     * @param tasaDeInteres the tasaDeInteres to set
     */
    public void setTasaDeInteres(float tasaDeInteres) {
        this.tasaDeInteres = tasaDeInteres;
    }
    
    private int contarCreditos(Creditos[] arreglo, String id) {
        int salida=0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getID() == ID)
                salida++;
        }
        return salida;
    }
    
    public int[] buscarCreditos(Creditos[] arreglo, String id) {
        int[] posiciones = new int[contarCreditos(arreglo, id)];
        int posicion=0;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i].getID() == ID) {
                posiciones[posicion]=i;
                posicion++;
            }  
        }
        return posiciones;
    }
}
