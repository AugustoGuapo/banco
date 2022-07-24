/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases_modelo;


import interfaces_de_usuario.InicioSesion;
import interfaces_de_usuario.BaseDeDatos;
import java.io.File;
import java.io.IOException;



public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InicioSesion ventana = new InicioSesion();
        ventana.setVisible(true);
        Empleados empleado = new Empleados();
        empleado.setNombre("Empleado prueba");
        Credenciales credenciales = new Credenciales();
        credenciales.setUsuario("123456");
        credenciales.setContraseña("123456");
        empleado.setCredenciales(credenciales);
        BaseDeDatos.sistema.añadirEmpleado(empleado);
        BaseDeDatos.cargarDatos();
        AccesoAleatorio id = new AccesoAleatorio(8);
        //new PruebaDeArchivosCreacionCuenta().setVisible(true);
        //new PruebaVisualizacionDatosFicheros().setVisible(true);

    }
}
