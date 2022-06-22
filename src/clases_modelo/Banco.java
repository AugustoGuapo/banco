/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases_modelo;

import interfaces_de_usuario.CreacionDeCuenta;
import interfaces_de_usuario.InicioSesion;
import interfaces_de_usuario.PanelClientes;
import interfaces_de_usuario.PanelEmpleados;

/**
 *
 * @author user
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        InicioSesion ventana = new InicioSesion();
        //CreacionDeCuenta ventana = new CreacionDeCuenta();
        //PanelEmpleados ventana = new PanelEmpleados();
        //PanelClientes ventana = new PanelClientes();
        ventana.setVisible(true);
    }
    
}
