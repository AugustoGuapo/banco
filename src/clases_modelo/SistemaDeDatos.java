/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.util.Arrays;

/**
 *
 * @author user
 */
public class SistemaDeDatos {
    
    Clientes[] listaClientes;
    Empleados[] listaEmpleados;
    Cuentas[] listaCuentas;
    Creditos[] listaCreditos;
    TarjetaDeCredito[] listaTarjetasDeCredito;
    Cdt[] listaCDT;
    
    public SistemaDeDatos(){
        listaClientes= new Clientes[1];
        listaEmpleados = new Empleados[1];
        listaCuentas = new Cuentas[1];
        listaCreditos = new Creditos[1];
        listaTarjetasDeCredito = new TarjetaDeCredito[1];
        listaCDT = new Cdt[1];
    }
    
    public void setCliente(Clientes cliente, int pos) {
        listaClientes[pos] = cliente;
    }
    
    public Clientes getCliente(int pos) {
        return listaClientes[pos];
    }
    
    public void setEmpleado(Empleados empleado, int pos) {
        listaEmpleados[pos] = empleado;
    }
    
    public Empleados getEmpleado(int pos) {
        return listaEmpleados[pos];
    }
    
    public void setCuenta(Cuentas cuenta, int pos) {
        listaCuentas[pos] = cuenta;
        aumentarListaCuentas();
    }
    
    public Cuentas getCuenta(int pos) {
        return listaCuentas[pos];
    }
    
    public void setCredito(Creditos credito, int pos) {
        listaCreditos[pos] = credito;
    }
    
    public Creditos getCredito(int pos) {
        return listaCreditos[pos];
    }
    
    public void setTarjetaDeCredito(TarjetaDeCredito tdc, int pos) {
        listaTarjetasDeCredito[pos] = tdc;
    }
    
    public TarjetaDeCredito getTarjetaDeCredito(int pos) {
        return listaTarjetasDeCredito[pos];
    }
    
    public void setCDT(Cdt cdt, int pos) {
        listaCDT[pos] = cdt;
    }
    
    public Cdt getCDT(int pos) {
        return listaCDT[pos];
    }
    
    public int tamañoListaClientes() {
        return listaClientes.length;
    }
        
    public int tamañoListaCuentas() {
        return listaCuentas.length;
    }    
    public int tamañoListaCreditos() {
        return listaCreditos.length;
    }    
        
    public int tamañoListaTDC() {
        return listaTarjetasDeCredito.length;
    }
    public int tamañoListaCDT() {
        return listaCDT.length;
    } 
    public void aumentarListaClientes() {
        listaClientes = Arrays.copyOf(listaClientes, listaClientes.length+1);
    }

    public void aumentarListaEmpleados() {
        listaEmpleados = Arrays.copyOf(listaEmpleados, listaEmpleados.length+1);
    }

    public void aumentarListaCuentas() {
        listaCuentas = Arrays.copyOf(listaCuentas, listaCuentas.length+1);
    }

    public void aumentarListaCreditos() {
        listaCreditos = Arrays.copyOf(listaCreditos, listaCreditos.length+1);
    }

    public void aumentarListaTarjetasDeCredito() {
        listaTarjetasDeCredito = Arrays.copyOf(listaTarjetasDeCredito, listaTarjetasDeCredito.length+1);
    }

    public void aumentarListaCDT() {
        listaCDT = Arrays.copyOf(listaCDT, listaCDT.length+1);
    }
}
