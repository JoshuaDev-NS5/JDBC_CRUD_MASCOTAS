package org.example.DTOs;

public class MascotaTablaDTO {
    private String ID_Mascota;
    private String ID_Estado;
    private String ID_Raza;
    private String ID_Tipo_Mascota;
    private String Nombre;
    private String Fecha_de_nacimiento;
    private Double Peso;
    private String ID_Cliente;
    private String Genero;
    private byte[] Foto;
    private String Fec_Registro;
    private String Usu_Registrado;
    private String Fec_ULT_MOD;
    private String Use_utl_mod;


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

    public String getID_Raza() {
        return ID_Raza;
    }

    public void setID_Raza(String ID_Raza) {
        this.ID_Raza = ID_Raza;
    }

    public String getID_Tipo_Mascota() {
        return ID_Tipo_Mascota;
    }

    public void setID_Tipo_Mascota(String ID_Tipo_Mascota) {
        this.ID_Tipo_Mascota = ID_Tipo_Mascota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha_de_nacimiento() {
        return Fecha_de_nacimiento;
    }

    public void setFecha_de_nacimiento(String fecha_de_nacimiento) {
        Fecha_de_nacimiento = fecha_de_nacimiento;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        Peso = peso;
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

    public void setGenero(String genero) {
        Genero = genero;
    }

    public byte[] getFoto() {
        return Foto;
    }

    public void setFoto(byte[] foto) {
        Foto = foto;
    }

    public String getFec_Registro() {
        return Fec_Registro;
    }

    public void setFec_Registro(String fec_Registro) {
        Fec_Registro = fec_Registro;
    }

    public String getUsu_Registrado() {
        return Usu_Registrado;
    }

    public void setUsu_Registrado(String usu_Registrado) {
        Usu_Registrado = usu_Registrado;
    }

    public String getFec_ULT_MOD() {
        return Fec_ULT_MOD;
    }

    public void setFec_ULT_MOD(String fec_ULT_MOD) {
        Fec_ULT_MOD = fec_ULT_MOD;
    }

    public String getUse_utl_mod() {
        return Use_utl_mod;
    }

    public void setUse_utl_mod(String use_utl_mod) {
        Use_utl_mod = use_utl_mod;
    }
}
