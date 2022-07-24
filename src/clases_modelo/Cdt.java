/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

/**
 *
 * @author user
 */
public class Cdt extends Productos {
    private int ID;
    private float tasaDeInteres;
    private int plazo;
    private float montoDepositado;
    private float montoARetirar;
    private String estado;
    
    public Cdt(){};

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

    /**
     * @return the plazo
     */
    public int getPlazo() {
        return plazo;
    }

    /**
     * @param plazo the plazo to set
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    /**
     * @return the montoDepositado
     */
    public float getMontoDepositado() {
        return montoDepositado;
    }

    /**
     * @param montoDepositado the montoDepositado to set
     */
    public void setMontoDepositado(float montoDepositado) {
        this.montoDepositado = montoDepositado;
    }

    /**
     * @return the montoARetirar
     */
    public float getMontoARetirar() {
        return montoARetirar;
    }

    /**
     * @param montoARetirar the montoARetirar to set
     */
    public void setMontoARetirar(float montoARetirar) {
        this.montoARetirar = montoARetirar;
    }
    
    /**
     * Calcula y hace set al atributo montoARetirar 
     */
   public void calculoMontoFinal() {
      montoARetirar = montoDepositado*(tasaDeInteres+1);
   }
   
   /**
    * Determina el interés que tendrá el CDT con un maximo de 6%
    * y un mínimo de 1.4%, dependiendo del plazo que se elija
    */
   public void determinarInteres() {
       float tasa = (plazo*6)/360;
       if(tasa>6) 
           tasaDeInteres=(float)0.06;
       else if (tasa<1.4) 
           tasaDeInteres=(float)0.014;         
       else
           tasaDeInteres=tasa/100;
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
    
    private int contarCDTs(Cdt[] arreglo, String id) {
        int salida=0;
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i].getID()==ID)
                salida++;
        }
        return salida;
    }
    
    public int[] buscarCDTs(Cdt[] arreglo, String id) {
        int[] posiciones = new int[contarCDTs(arreglo, id)];
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
