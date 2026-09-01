package org.example.DTOs;

public class MascotaListaDTO {
    private String ID_Mascota;
    private String Nombre;
    private String Genero;
    private int Edad;
    private Double Peso;
    private String Estado;
    private String Tipo_Mascota;
    private String Cliente;
    /*
    public MascotaListaDTO(String id_Mascota, String nombre, String genero, int edad, Double peso, String estado, String tipo_Mascota, String cliente) {
        this.ID_Mascota = id_Mascota;
        this.Nombre = nombre;
        this.Genero = genero;
        this.Edad = edad;
        this.Peso = peso;
        this.Estado = estado;
        this.Tipo_Mascota = tipo_Mascota;
        this.Cliente = cliente;
    }*/

    public String getID_Mascota() {
        return ID_Mascota;
    }

    public void setID_Mascota(String ID_Mascota) {
        this.ID_Mascota = ID_Mascota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        Peso = peso;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getTipo_Mascota() {
        return Tipo_Mascota;
    }

    public void setTipo_Mascota(String tipo_Mascota) {
        Tipo_Mascota = tipo_Mascota;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }
}
