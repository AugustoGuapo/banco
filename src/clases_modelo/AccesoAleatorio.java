package clases_modelo;

import java.io.*;
import java.time.LocalDate;
/**
 *
 * @author Augusto Díaz
 */
public class AccesoAleatorio {
    private static RandomAccessFile flujo;
    private int numeroRegistros;
    private static int tamañoRegistro;
    
    public AccesoAleatorio(int tamaño) {
        tamañoRegistro = tamaño;
    }
    
    public void crearArchivo(File archivo) throws IOException {
        if(archivo.exists() && !archivo.isFile()) {
            throw new IOException(archivo.getName() + " no es un archivo");
        }
        flujo = new RandomAccessFile(archivo,"rw");
        numeroRegistros = (int) Math.ceil(
                (double) flujo.length() / (double) tamañoRegistro);
    }
    
    public void cerrar() throws IOException {
        flujo.close();
    }
    
    public void setCliente(Clientes cliente) throws IOException {
        flujo.seek(getNumeroRegistros()*tamañoRegistro);       
        flujo.writeInt(cliente.getID());
        flujo.writeUTF(cliente.getNombre()+"\n");
        flujo.writeUTF(cliente.getNumeroDeDocumento()+"\n");
        flujo.writeUTF(cliente.getFechaDeNacimiento().toString()+"\n");
        flujo.writeUTF(cliente.getCorreoElectronico()+"\n");
        flujo.writeUTF(cliente.getNumeroTelefono()+"\n");
        flujo.writeUTF(cliente.getSexo()+"\n");
        flujo.writeUTF(cliente.getEstado()+"\n");
        flujo.writeUTF(cliente.getCredenciales().getUsuario()+"\n");
        flujo.writeUTF(cliente.getCredenciales().getContraseña()+"\n"); 
    }
    
    public void setCliente(Clientes cliente, int i) throws IOException {
        flujo.seek(i*tamañoRegistro);       
        flujo.writeInt(cliente.getID());
        flujo.writeUTF(cliente.getNombre()+"\n");
        flujo.writeUTF(cliente.getNumeroDeDocumento()+"\n");
        flujo.writeUTF(cliente.getFechaDeNacimiento().toString()+"\n");
        flujo.writeUTF(cliente.getCorreoElectronico()+"\n");
        flujo.writeUTF(cliente.getNumeroTelefono()+"\n");
        flujo.writeUTF(cliente.getSexo()+"\n");
        flujo.writeUTF(cliente.getEstado()+"\n");
        flujo.writeUTF(cliente.getCredenciales().getUsuario()+"\n");
        flujo.writeUTF(cliente.getCredenciales().getContraseña()+"\n"); 
    }
    
    public Clientes getCliente(int i) throws IOException {
        Clientes salida = new Clientes();
        flujo.seek(i*tamañoRegistro);
        salida.setID(flujo.readInt());
        salida.setNombre(flujo.readUTF().strip());
        salida.setNumeroDeDocumento(flujo.readUTF().strip());
        salida.setFechaDeNacimiento(LocalDate.parse(flujo.readUTF().strip()));
        salida.setCorreoElectronico(flujo.readUTF().strip());
        salida.setNumeroTelefono(flujo.readUTF().strip());
        salida.setSexo(flujo.readUTF().strip());
        salida.setEstado(flujo.readUTF().strip());
        salida.getCredenciales().setUsuario(flujo.readUTF().strip());
        salida.getCredenciales().setContraseña(flujo.readUTF().strip()); 
        return salida;
    }
    
    public void setCuenta(Cuentas cuenta) throws IOException {
        flujo.seek(numeroRegistros*tamañoRegistro);
        flujo.writeInt(cuenta.getID());
        flujo.writeUTF(cuenta.getNumeroCuenta()+"\n");
        flujo.writeUTF(cuenta.getTipoDeCuenta()+"\n");
        flujo.writeFloat(cuenta.getSaldo());
        flujo.writeUTF(cuenta.getEstado()+"\n");
    }
    
    public void setCuenta(Cuentas cuenta, int i) throws IOException {
        flujo.seek(i*tamañoRegistro);
        flujo.writeInt(cuenta.getID());
        flujo.writeUTF(cuenta.getNumeroCuenta()+"\n");
        flujo.writeUTF(cuenta.getTipoDeCuenta()+"\n");
        flujo.writeFloat(cuenta.getSaldo());
        flujo.writeUTF(cuenta.getEstado()+"\n");
    }
    
    public Cuentas getCuenta(int i) throws IOException {
        Cuentas salida = new Cuentas();
        flujo.seek(i*tamañoRegistro);
        salida.setID(flujo.readInt());
        salida.setNumeroCuenta(flujo.readUTF().strip());
        salida.setTipoDeCuenta(flujo.readUTF().strip());
        salida.setSaldo(flujo.readFloat());
        salida.setEstado(flujo.readUTF().strip());
        return salida;
    }
    
    public void setCdt(Cdt cdt, int i) throws IOException {
        flujo.seek(i*tamañoRegistro);
        flujo.writeInt(cdt.getID());
        flujo.writeFloat(cdt.getTasaDeInteres());
        flujo.writeInt(cdt.getPlazo());
        flujo.writeFloat(cdt.getMontoDepositado());
        flujo.writeFloat(cdt.getMontoARetirar());
        flujo.writeUTF(cdt.getEstado()+"\n");
        flujo.writeUTF(cdt.getFechaRetiro().toString()+"\n");
    }

    public Cdt getCdt(int i) throws IOException {
        Cdt cdt = new Cdt();
        flujo.seek(i*tamañoRegistro);
        cdt.setID(flujo.readInt());
        cdt.setTasaDeInteres(flujo.readFloat());
        cdt.setPlazo(flujo.readInt());
        cdt.setMontoDepositado(flujo.readFloat());
        cdt.setMontoARetirar(flujo.readFloat());
        cdt.setEstado(flujo.readUTF().strip());
        cdt.setFechaRetiro(LocalDate.parse(flujo.readUTF().strip()));
        return cdt;
    }
    
    public void setTdc(TarjetaDeCredito tdc, int i) throws IOException {
        flujo.seek(i*tamañoRegistro);
        flujo.writeInt(tdc.getID());
        flujo.writeUTF(tdc.getNumeroDeTarjeta()+"\n");
        flujo.writeUTF(tdc.getFechaDeVencimiento().toString()+"\n");
        flujo.writeUTF(tdc.getCVV() + "\n");
        flujo.writeFloat(tdc.getMontoTotal());
        flujo.writeFloat(tdc.getMontoAdeudado());
        flujo.writeInt(tdc.getNroCuotasAdeudadas());
        flujo.writeFloat(tdc.getValorCuota());
        flujo.writeUTF(tdc.getEstado()+"\n");
        flujo.writeUTF(tdc.getFechaProximoPago().toString()+"\n");
    }
    
    public TarjetaDeCredito getTdc(int i) throws IOException {
        TarjetaDeCredito tdc = new TarjetaDeCredito();
        flujo.seek(i*tamañoRegistro);
        tdc.setID(flujo.readInt());
        tdc.setNumeroDeTarjeta(flujo.readUTF().strip());
        tdc.setFechaDeVencimiento(LocalDate.parse(flujo.readUTF().strip()));
        tdc.setCVV(flujo.readUTF().strip());
        tdc.setMontoTotal(flujo.readFloat());
        tdc.setMontoAdeudado(flujo.readFloat());
        tdc.setNroCuotasAdeudadas(flujo.readInt());
        tdc.setValorCuota(flujo.readFloat());
        tdc.setEstado(flujo.readUTF().strip());
        tdc.setFechaProximoPago(LocalDate.parse(flujo.readUTF().strip()));
        return tdc;
    }
    
    public void setCredito(Creditos credito, int i) throws IOException {
        flujo.seek(i*tamañoRegistro);
        flujo.writeFloat(credito.getMontoAdeudado());
        flujo.writeInt(credito.getID());
        flujo.writeUTF(credito.getTipoDeCredito());
        flujo.writeFloat(credito.getTasaDeInteres());
        flujo.writeFloat(credito.getMonto());
        flujo.writeInt(credito.getNumeroDeCuotas());
        flujo.writeInt(credito.getCuotasAdeudadas());
        flujo.writeUTF(credito.getEstado()+"\n");
        flujo.writeUTF(credito.getFechaProximoPago().toString()+"\n");
        flujo.writeFloat(credito.getValorCuota());
    }
    
    public Creditos getCredito(int i) throws IOException {
        Creditos credito = new Creditos();
        flujo.seek(i*tamañoRegistro);
        credito.setMontoAdeudado(flujo.readFloat());
        credito.setID(flujo.readInt());
        credito.setTipoDeCredito(flujo.readUTF());
        credito.setTasaDeInteres(flujo.readFloat());
        credito.setMonto(flujo.readFloat());
        credito.setNumeroDeCuotas(flujo.readInt());
        credito.setCuotasAdeudadas(flujo.readInt());
        credito.setEstado(flujo.readUTF().strip());
        credito.setFechaProximoPago(LocalDate.parse(flujo.readUTF().strip()));
        credito.setValorCuota(flujo.readFloat());
        return credito;
    }
    
    public void guardarId(int id) throws IOException {
        flujo.seek(0);
        flujo.writeInt(id);
    }
    
    public int cargarId() throws IOException {
        flujo.seek(0);
        return flujo.readInt();
    }
    
    /**
     * @return the numeroRegistros
     */
    public int getNumeroRegistros() {
        return numeroRegistros;
    }
}
