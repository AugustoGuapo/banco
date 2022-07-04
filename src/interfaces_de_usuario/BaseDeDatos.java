/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces_de_usuario;
import clases_modelo.*;




/**
 *
 * @author user
 */
public class BaseDeDatos {
    public static SistemaDeDatos sistema = new SistemaDeDatos();
    public static int contadorParaId = 0;
    public static int IDsesionIniciada;   
    public static String nroCuentaEnUso;
    
    BaseDeDatos(){}
    public static Cuentas buscarCuentaPendientePorID(int id) {
        Cuentas cuentaSalida=new Cuentas();
        for (int i = 0; i < sistema.buscarClientePorID(id).cantidadDeProductos(); i++) {
            if(sistema.buscarClientePorID(id).getProductos(i) instanceof Cuentas cuenta) {
                if(cuenta.getEstado().equals("Pendiente"))
                    cuentaSalida = cuenta;
            }
        }
        return cuentaSalida;
    }

}

