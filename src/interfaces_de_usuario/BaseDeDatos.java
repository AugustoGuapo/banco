/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces_de_usuario;
import clases_modelo.*;
import java.util.ArrayList;


/**
 *
 * @author user
 */
public class BaseDeDatos {
    public static SistemaDeDatos sistema = new SistemaDeDatos();
    public static BdParaInicioSesion login = new BdParaInicioSesion();
    public static ArrayList<Clientes> clientesPendientes = new ArrayList();
    public static ArrayList<String> usuariosPendientes = new ArrayList();
    public static ArrayList<String> contraseñasPendientes = new ArrayList();
    public static ArrayList<String> tiposDeCuentaPendientes = new ArrayList();
    public static int cuentaDeID = 0;
    public static int IDsesionIniciada;
    
    
}
