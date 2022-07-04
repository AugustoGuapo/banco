/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases_modelo;

import interfaces_de_usuario.CreacionDeCuenta;
import interfaces_de_usuario.InicioSesion;
import interfaces_de_usuario.PanelClientes;
import interfaces_de_usuario.PanelEmpleados;
import interfaces_de_usuario.ConsignarRetirarCuenta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author user
 */
public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InicioSesion ventana = new InicioSesion();
        //CreacionDeCuenta ventana = new CreacionDeCuenta();
        //PanelEmpleados ventana = new PanelEmpleados();
        //PanelClientes ventana = new PanelClientes();
        //ConsignarRetirarCuenta ventana = new ConsignarRetirarCuenta();
        ventana.setVisible(true);
        //System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }
    
}
