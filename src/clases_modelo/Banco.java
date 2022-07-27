/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases_modelo;


import interfaces_de_usuario.InicioSesion;
import interfaces_de_usuario.BaseDeDatos;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
        Empleados empleado = new Empleados();
        empleado.setNombre("Empleado prueba");//NOMBRE DEL ADMIN
        Credenciales credenciales = new Credenciales();
        credenciales.setUsuario("123456");//USUARIO ADMIN
        credenciales.setContraseña("123456");//CONTRASEÑA ADMIN
        empleado.setCredenciales(credenciales);
        BaseDeDatos.sistema.añadirEmpleado(empleado);
        BaseDeDatos.cargarDatos();
        reiniciarId();


    }
    
    
    /**
     * Método que solo debe utilizarse en caso de borrar todos los archivos .dat creados
     * se recomienda utilizarlo como una unica instrucción del main, correrlo y para que cree
     * el archivo que va a llevar cuenta de los ID para los clientes y borrar su ejecución
     */
    public static void reiniciarId() {
        try {
            AccesoAleatorio id = new AccesoAleatorio(8);
            id.crearArchivo(new File("id.dat"));
            id.guardarId(0);
            id.cerrar();
        } catch (IOException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


        
