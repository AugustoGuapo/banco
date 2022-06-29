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
    
    private ArrayList<Clientes> listaClientes;
    
    
    
    
    
    public SistemaDeDatos(){
        listaClientes = new ArrayList();
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

    
    
    
    
}