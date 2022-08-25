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
     * Método que reinicia a 0 el contador del ID de los clientes, la forma de usarlo es descomentarlo y comentar 
     * el método "cargarDatos()" de la clase BaseDeDatos, luego cerrar el programa, volver a hacer comentario este método
     * y descomentar cargarDatos(), se recomienda utilizarlo solo cuando se reinicie por completo los datos del programa (se
     * borren los archivos .dat).
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


        
