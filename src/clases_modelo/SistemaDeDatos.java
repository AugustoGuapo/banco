/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class SistemaDeDatos {
    
    /**
     * ArrayList para guardar todos los productos
     */
    
    private ArrayList<Clientes> listaClientes;
    private ArrayList<Empleados> listaEmpleados;
    private ArrayList<Cuentas> listaCuentas;
    private ArrayList<Creditos> listaCreditos;
    private ArrayList<Cdt> listaCdt;
    private ArrayList<TarjetaDeCredito> listaTdc;

    public SistemaDeDatos(){
        listaClientes = new ArrayList();
        listaEmpleados = new ArrayList();
        listaCuentas= new ArrayList();
        listaCreditos = new ArrayList();
        listaCdt = new ArrayList();
        listaTdc = new ArrayList();
    }

    public void añadirCliente(Clientes cliente) {
        listaClientes.add(cliente);
    }
    
    public Clientes getCliente(int pos) {
        return listaClientes.get(pos);
    }
    
    public int cantClientes() {
        return listaClientes.size();
    }
    
    public Clientes buscarClientePorID(int id) {
        Clientes cliente = new Clientes();
        for (int i = 0; i < listaClientes.size(); i++) {
            if(listaClientes.get(i).getID()==id)
                cliente = listaClientes.get(i);
        }
        return cliente;
    }
    
    public void añadirEmpleado(Empleados empleado) {
        listaEmpleados.add(empleado);
    }
    
    public Empleados getEmpleado(int i) {
        return listaEmpleados.get(i);
    }
    
    public void setCuentas(Cuentas entrada) {
        listaCuentas.add(entrada);
    }

    public Cuentas getCuentas(int pos) {
        return listaCuentas.get(pos);
    }

    public int getCantCuentas() {
        return listaCuentas.size();
    }

    public void setCreditos(Creditos entrada) {
        listaCreditos.add(entrada);
    }

    public Creditos getCreditos(int pos) {
        return listaCreditos.get(pos);
    }

    public int getCantCreditos() {
        return listaCreditos.size();
    }

    public void setCdt(Cdt entrada) {
        listaCdt.add(entrada);
    }

    public Cdt getCdt(int pos) {
        return listaCdt.get(pos);
    }

    public int getCantCdt() {
        return listaCdt.size();
    }

    public void setTdc(TarjetaDeCredito entrada) {
        listaTdc.add(entrada);
    }

    public TarjetaDeCredito getTdc(int pos) {
        return listaTdc.get(pos);
    }

    public int getCantTdc() {
        return listaTdc.size();
    }

}