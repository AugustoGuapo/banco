/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.util.Random;

/**
 *
 * @author user
 */
public class Cuentas extends Productos{
    private int ID;
    private String numeroCuenta;
    private String tipoDeCuenta;
    private float saldo;
    private String estado;

    /**
     * @return the ID
     */
    @Override
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
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta  the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta=numeroCuenta;
    }

    /**
     * @return the tipoDeCuenta
     */
    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    /**
     * @param tipoDeCuenta the tipoDeCuenta to set
     */
    public void setTipoDeCuenta(String tipoDeCuenta) {
        this.tipoDeCuenta = tipoDeCuenta;
    }

    /**
     * @return the saldo
     */
    public float getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public void consignar(float monto) {
        saldo+=monto;
    }
    
    public void retirar(float monto) {
        saldo-=monto;
    }
    
    public void crearNumeroCuenta() {
        String salida="";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            salida+= random.nextInt(9);
        }
        numeroCuenta = salida;      
    }

    /**
     * @return the estado
     */
    @Override
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