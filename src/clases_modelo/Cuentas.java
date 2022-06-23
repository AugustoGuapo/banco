/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

/**
 *
 * @author user
 */
public class Cuentas {
    private int ID;
    private String numeroCuenta;
    private String tipoDeCuenta;
    private float saldo;

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
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
    
    private int contarCuentas(Cuentas[] arreglo, String id) {
        int salida=0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getID() == ID)
                salida++;
        }
        return salida;
    }
    
    public int[] buscarCuentas(Cuentas[] arreglo, String id) {
        int[] posiciones = new int[contarCuentas(arreglo, id)];
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
