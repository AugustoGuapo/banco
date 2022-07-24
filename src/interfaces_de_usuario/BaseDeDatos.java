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
    public static int contadorParaId;
    public static int IDsesionIniciada;   
    public static String nroCuentaEnUso;
    
    BaseDeDatos(){}
    /*
        public static Cuentas buscarCuentaPendientePorID(int id) {
        Cuentas cuentaSalida=new Cuentas();
        for (int i = 0; i < sistema.buscarClientePorID(id).cantidadDeProductos(); i++) {
            if(sistema.buscarClientePorID(id).getProducto(i) instanceof Cuentas cuenta) {
                if(cuenta.getEstado().equals("Pendiente"))
                    cuentaSalida = cuenta;
            }
        }
        return cuentaSalida;
    }
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

