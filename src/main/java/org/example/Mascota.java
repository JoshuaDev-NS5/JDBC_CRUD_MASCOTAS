package org.example;

public class Mascota {
    private String ID_Mascota;
    private String ID_Estado;
    private String Raza;
    private String ID_Tipo_Mascota;
    private String NombreMascota;
    private String Edad;
    private double Peso;
    private String ID_Cliente;
    private String Genero;
    private String Fec_Registro;
    private String UsuarioRegistro;
    private String Fec_Ult_Mod;
    private String Usu_Ult_Mod;


    public String getID_Mascota() {
        return ID_Mascota;
    }

    public void setID_Mascota(String ID_Mascota) {
        this.ID_Mascota = ID_Mascota;
    }

    public String getID_Estado() {
        return ID_Estado;
    }

    public void setID_Estado(String ID_Estado) {
        this.ID_Estado = ID_Estado;
    }

    public String getRaza() {
        return Raza;
    }

    public void setRaza(String Raza) {
        this.Raza = Raza;
    }

    public String getID_Tipo_Mascota() {
        return ID_Tipo_Mascota;
    }

    public void setID_Tipo_Mascota(String ID_Tipo_Mascota) {
        this.ID_Tipo_Mascota = ID_Tipo_Mascota;
    }

    public String getNombreMascota() {
        return NombreMascota;
    }

    public void setNombreMascota(String NombreMascota) {
        this.NombreMascota = NombreMascota;
    }

    public String getEdad() {
        return Edad;
    }

    public void setFecha_de_Nacimiento(String Fecha_de_Nacimiento) {
        this.Edad = Fecha_de_Nacimiento;
    }

    public double getPeso() {
        return Peso;
    }

    public void setPeso(double Peso) {
        this.Peso = Peso;
    }

    public String getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(String ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }
}
