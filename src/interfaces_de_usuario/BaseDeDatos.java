/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces_de_usuario;
import clases_modelo.*;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;




/**
 *
 * @author user
 */
public class BaseDeDatos {
    public static SistemaDeDatos sistema = new SistemaDeDatos();
    public static int contadorParaId; //Mantiene guardado el número de ID para los clientes y puedan seguir la secuencia
    public static int IDsesionIniciada;   //ID del usuario que acaba de iniciar sesión, se usa para cargar los elementos del panel clientes
    public static String nroCuentaEnUso; //Variable auxiliar para consignaciones y retiros
    
    BaseDeDatos(){}


    /**
     * Método que carga los datos de los clientes y todos sus productos a partir de los archivos
     */
    public static void cargarDatos() {
        try {
            cargarClientes();         
            cargarCuentas();         
            cargarCdt();            
            cargarTdc();
            cargarCreditos();
            cargarId();
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Hubo un error al cargar los datos, consulte con el administrador "
                    + "de su sistema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

     /**
     * Método que guarda los clientes y sus productos a los archivos
     */
    public static void guardarCambios()  {
        try {
            guardarClientes();
            guardarCuentas();
            guardarCdt();
            guardarTdc();
            guardarCreditos();
            guardarId();
        } catch (IOException ioex) {
            JOptionPane.showMessageDialog(null, "Sucedió un error pero tranquilo, no es tu culpa", "Error al guardar"
                    ,JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
    *
    */
    private static void guardarCreditos() throws IOException {
        AccesoAleatorio rafCreditos = new AccesoAleatorio(256);
        rafCreditos.crearArchivo(new File("Creditos.dat"));
        for (int i = 0; i < sistema.getCantCreditos(); i++) {
            rafCreditos.setCredito(sistema.getCreditos(i), i);
        }
        rafCreditos.cerrar();
    }

    private static void guardarTdc() throws IOException {
        AccesoAleatorio rafTdc = new AccesoAleatorio(256);
        rafTdc.crearArchivo(new File("Tdc.dat"));
        for (int i = 0; i < sistema.getCantTdc(); i++) {
            rafTdc.setTdc(sistema.getTdc(i), i);
        }
        rafTdc.cerrar();
    }

    private static void guardarCdt() throws IOException {
        AccesoAleatorio rafCdt = new AccesoAleatorio(256);
        rafCdt.crearArchivo(new File("Cdt.dat"));
        for (int i = 0; i < sistema.getCantCdt(); i++) {
            rafCdt.setCdt(sistema.getCdt(i), i);
        }
        rafCdt.cerrar();
    }

    private static void guardarCuentas() throws IOException {
        AccesoAleatorio rafCuentas = new AccesoAleatorio(256);
        rafCuentas.crearArchivo(new File("Cuentas.dat"));
        for (int i = 0; i < sistema.getCantCuentas(); i++) {
            rafCuentas.setCuenta(sistema.getCuentas(i), i);
        }
        rafCuentas.cerrar();
    }

    private static void guardarClientes() throws HeadlessException, IOException {
        AccesoAleatorio rafClientes = new AccesoAleatorio(512);
        rafClientes.crearArchivo(new File("Clientes.dat"));
        for (int i = 0; i < sistema.cantClientes(); i++) {
                rafClientes.setCliente(sistema.getCliente(i),i);
        }
        rafClientes.cerrar();
    }
    
    private static void guardarId() throws IOException {
        AccesoAleatorio id = new AccesoAleatorio(8);
        id.crearArchivo(new File("id.dat"));
        id.guardarId(contadorParaId);
        id.cerrar();
    }
    private static void cargarCreditos() throws IOException {
        AccesoAleatorio rafCreditos = new AccesoAleatorio(256);
        rafCreditos.crearArchivo(new File("Creditos.dat"));
        for (int i = 0; i < rafCreditos.getNumeroRegistros(); i++) {
            sistema.setCreditos(rafCreditos.getCredito(i));
        }
        rafCreditos.cerrar();
    }

    private static void cargarTdc() throws IOException {
        AccesoAleatorio rafTdc = new AccesoAleatorio(256);
        rafTdc.crearArchivo(new File("Tdc.dat"));
        for (int i = 0; i < rafTdc.getNumeroRegistros(); i++) {
            sistema.setTdc(rafTdc.getTdc(i));
        }
        rafTdc.cerrar();
    }

    private static void cargarCdt() throws IOException {
        AccesoAleatorio rafCdt = new AccesoAleatorio(256);
        rafCdt.crearArchivo(new File("Cdt.dat"));
        for (int i = 0; i < rafCdt.getNumeroRegistros(); i++) {
            sistema.setCdt(rafCdt.getCdt(i));
        }
        rafCdt.cerrar();
    }

    private static void cargarCuentas() throws IOException {        
        AccesoAleatorio rafCuentas = new AccesoAleatorio(256);
        rafCuentas.crearArchivo(new File("Cuentas.dat"));
        for (int i = 0; i <rafCuentas.getNumeroRegistros(); i++) {
            sistema.setCuentas(rafCuentas.getCuenta(i));
        }
        rafCuentas.cerrar();
    }

    private static void cargarClientes() throws IOException {
        AccesoAleatorio rafClientes= new AccesoAleatorio(512);
        rafClientes.crearArchivo(new File("Clientes.dat"));
        for (int i = 0; i < rafClientes.getNumeroRegistros(); i++) {
            sistema.añadirCliente(rafClientes.getCliente(i));
        }
        rafClientes.cerrar();
    }
    
    private static void cargarId() throws IOException {
        AccesoAleatorio id = new AccesoAleatorio(8);
        id.crearArchivo(new File("id.dat"));
        contadorParaId= id.cargarId();
        id.cerrar();
    }
}

