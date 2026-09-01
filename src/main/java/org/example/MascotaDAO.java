package org.example;
import org.example.Mascota;
import org.example.DTOs.MascotaListaDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {
    //Esta clase nos permitira almacenar la logica de cada consulta

    //Metodo que devuelve una lista de mascotas
    public List<MascotaListaDTO> ListarMascotas(){
        String SQL = "EXEC dbo.usp_Listar_MASCOTAS";
        List<MascotaListaDTO> Mascotas=new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement ps = CNX.prepareStatement(SQL);
            ResultSet resultado = ps.executeQuery() ){

            while (resultado.next()){
                MascotaListaDTO mascotaListaDTO= new MascotaListaDTO();
                mascotaListaDTO.setID_Mascota(resultado.getString("ID_mascota"));
                mascotaListaDTO.setNombre(resultado.getString("nomMascota"));
                mascotaListaDTO.setGenero(resultado.getString("Genero"));
                mascotaListaDTO.setEdad(resultado.getInt("Edad"));
                mascotaListaDTO.setPeso(resultado.getDouble("peso"));
                mascotaListaDTO.setEstado(resultado.getString("estado"));
                mascotaListaDTO.setTipo_Mascota(resultado.getString("tipo_mascota"));
                mascotaListaDTO.setCliente(resultado.getString("Cliente"));

                Mascotas.add(mascotaListaDTO);
            }
            return Mascotas;


        }catch (SQLException ErrorSQL ) {
            System.out.println("Error de codigo Metodo Listar mascotas: " + ErrorSQL);
        }
        return null;
    }
    //Metodo que devuelve una sola mascota con su información
    public Mascota ConsultarMascota(String ID){
        return null;
    }

    //Metodo que inserta una clase a Mascota a la tabla de mascota
    public void Insertar(Mascota mascota){

    }

    //Meto que actualiza una mascota
    public void Actualizar_Mascota(Mascota mascota){

    }

    public void Eliminar(String ID){

    }



}
