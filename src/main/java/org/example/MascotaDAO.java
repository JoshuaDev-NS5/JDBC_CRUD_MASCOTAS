package org.example;
import org.example.DTOs.ClienteDTO;
import org.example.DTOs.EstadoDTO;
import org.example.DTOs.MascotaDTO;
//import org.example.Mascota;
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



        }catch (SQLException ErrorSQL ) {
            System.out.println("Error de codigo Metodo Listar mascotas: " + ErrorSQL);
        }
        return Mascotas;
    }
    //Metodo que devuelve una sola mascota con su información
    public MascotaDTO ConsultarMascota(String ID){
        //Creamos la cadena de sql
        String SQL= "EXEC dbo.usp_Consultar_MASCOTA " + ID;
        //Declaramos la instancia de mascota para guardar los datos;
        MascotaDTO mascotaDTO = new MascotaDTO();
        try (Connection CNX = Conexion.obtenerConexion();
             PreparedStatement ps = CNX.prepareStatement(SQL);
             ResultSet resultado = ps.executeQuery()){
            if(resultado.next()){//si resultado no muestra ninguna fila de mas se ejecuta
                mascotaDTO.setID_Mascota(resultado.getString("ID_mascota"));
                mascotaDTO.setNombre(resultado.getString("nomMascota"));
                mascotaDTO.setGenero(resultado.getString("Genero"));
                mascotaDTO.setFecha_de_nacimiento(resultado.getString("fecha_de_nacimiento"));
                mascotaDTO.setEdad(resultado.getInt("Edad"));
                mascotaDTO.setPeso(resultado.getDouble("peso"));
                mascotaDTO.setEstado(resultado.getString("estado"));
                mascotaDTO.setRaza(resultado.getString("nombre_raza"));
                mascotaDTO.setTipo_Mascota(resultado.getString("tipo_mascota"));
                mascotaDTO.setCliente(resultado.getString("Cliente"));
                mascotaDTO.setTelefono(resultado.getString("telfono"));
                mascotaDTO.setEmail(resultado.getString("Email"));
            }


        }catch (SQLException ErrorSQL){
            System.out.println("Error de codigo Metodo Listar mascotas: " + ErrorSQL);
        }

        return mascotaDTO;
    }

    //Metodo que inserta una clase a Mascota a la tabla de mascota
    public void Insertar(Mascota mascota){

    }

    //Meto que actualiza una mascota
    public void Actualizar_Mascota(Mascota mascota){

    }

    public void Eliminar(String ID){

    }


    //Traer datos de Clientes
    public List<ClienteDTO> Lisata_Clientes(){
        String SQL= "execute usp_Listar_CLIENTES";
        List<ClienteDTO> ClientesDTO = new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement stm= CNX.prepareStatement(SQL);
            ResultSet resultado = stm.executeQuery()){

            while (resultado.next()){//el bucle continúa hasta que se queda sin filas;
                ClienteDTO ClienteDTO = new ClienteDTO();
                ClienteDTO.setID_Cliente(resultado.getString("ID_cliente"));
                ClienteDTO.setNombreCompleto(resultado.getString("NombreCompleto"));
                ClienteDTO.setDNI(resultado.getString("DNI"));

                ClientesDTO.add(ClienteDTO);
            }

        }catch (SQLException ErrorSQL) {
            System.out.println("Error de codigo Metodo Listar Clientes: " + ErrorSQL);
        }
        return ClientesDTO;
    }

    // Traer datos de Estado
    public List<EstadoDTO> Listar_Estado(){
        String SQL = "EXECUTE usp_Listar_ESTADOS";
        List<EstadoDTO> Estados = new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement stm= CNX.prepareStatement(SQL);
            ResultSet resultado = stm.executeQuery()){

            while (resultado.next()){//el bucle continúa hasta que se queda sin filas;
                EstadoDTO EstadoDTO= new EstadoDTO();
                EstadoDTO.setID_Estado(resultado.getString("id_estado"));
                EstadoDTO.setEstado(resultado.getString("estado"));

                Estados.add(EstadoDTO);
            }

        }catch (SQLException ErrorSQL) {
            System.out.println("Error de codigo Metodo Listar Estados: " + ErrorSQL);
        }
        return Estados;

    }

}
