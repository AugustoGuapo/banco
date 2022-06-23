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
public class BdParaInicioSesion {
    private String[] usuarios;
    private String[] contraseñas;
    private ArrayList<Integer> ID = new ArrayList();
    
    public BdParaInicioSesion() {
        usuarios = new String[1];
        contraseñas = new String[1];
    }
    
    public void setUsuario(String usuario) {
        usuarios[usuarios.length-1] = usuario;
        aumentarArregloUsuarios();
    }
    
    public String getUsuario(int pos) {
        return usuarios[pos];
    }
    
    public void setContraseña(String contraseña) {
        contraseñas[contraseñas.length-1] = contraseña;
        aumentarArregloContraseñas();
    }
    public void setContraseña(String contraseña, int pos) {
        contraseñas[pos] = contraseña;
    }
    
    public String getContraseña(int pos) {
        return contraseñas[pos];
    }
    
    public void setID(int ID) {
        this.ID.add(ID);
    }
    
    public int getID(int pos) {
        return ID.get(pos);
    }
    
    private void aumentarArregloUsuarios() {
        String[] auxiliar = usuarios;
        usuarios = new String[auxiliar.length+1];
        System.arraycopy(auxiliar, 0, usuarios, 0, auxiliar.length);
    }
    
    private void aumentarArregloContraseñas() {
        String[] auxiliar = contraseñas;
        contraseñas = new String[auxiliar.length+1];
        System.arraycopy(auxiliar, 0, contraseñas, 0, auxiliar.length); 
    }
    
    public int verificarPosicionUsuario(String nombre) {
        int posicion =-1;
        for (int i = 0; i<usuarios.length; i++) {
            if(usuarios[i].equals(nombre)) {
                posicion=i;
                break;
            }
        }
        return posicion;
    }
    
    public boolean verificarClave(String nombre, String contraseña) {
        boolean resultado;
        int posicionUsuario = verificarPosicionUsuario(nombre);
        if(posicionUsuario>=0)
            resultado = contraseña.equals(contraseñas[posicionUsuario]);
        else
            resultado= false;
        return resultado; 
    }

    /**
     * @return the cantUsuarios
     */
    public int getCantUsuarios() {
        return usuarios.length;
    }
}
