package org.example;
import org.example.DTOs.*;
//import org.example.Mascota;

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
    public void Insertar(MascotaTablaDTO mascota){
        String SQL = "EXECUTE usp_Insertar_MASCOTA ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
        try (Connection CNX = Conexion.obtenerConexion();
             PreparedStatement stm = CNX.prepareStatement(SQL)){
            stm.setString(1, mascota.getID_Mascota());
            stm.setString(2, mascota.getID_Estado());
            stm.setString(3, mascota.getID_Raza());
            stm.setString(4, mascota.getID_Tipo_Mascota());
            stm.setString(5, mascota.getNombre());
            stm.setString(6, mascota.getFecha_de_nacimiento());
            stm.setDouble(7, mascota.getPeso());
            stm.setString(8, mascota.getID_Cliente());
            stm.setString(9, mascota.getGenero());
            stm.setBytes(10, mascota.getFoto());
            stm.setString(11, mascota.getFec_Registro());
            stm.setString(12, mascota.getUsu_Registrado());
            stm.setString(13, mascota.getFec_ULT_MOD());
            stm.setString(14, mascota.getUse_utl_mod());
            stm.executeUpdate();



        }catch (SQLException ErrorSQL){
            System.out.println("Error en el metodo DAO de Insertar: "+ ErrorSQL);
        }

    }

    //Meto que actualiza una mascota
    public void Actualizar_Mascota(Mascota mascota){

    }

    public void Eliminar(String ID){

    }


    //Traer datos de Clientes
    public List<ClienteDTO> Lisatar_Clientes(){
        String SQL= "execute usp_Listar_CLIENTES";
        List<ClienteDTO>  clientesDTO = new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement stm= CNX.prepareStatement(SQL);
            ResultSet resultado = stm.executeQuery()){

            while (resultado.next()){//el bucle continúa hasta que se queda sin filas;
                ClienteDTO ClienteDTO = new ClienteDTO();
                ClienteDTO.setID_Cliente(resultado.getString("ID_cliente"));
                ClienteDTO.setNombreCompleto(resultado.getString("NombreCompleto"));
                ClienteDTO.setDNI(resultado.getString("DNI"));

                clientesDTO.add(ClienteDTO);
            }

        }catch (SQLException ErrorSQL) {
            System.out.println("Error de codigo Metodo Listar Clientes: " + ErrorSQL);
        }
        return clientesDTO;
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

    //
    public List<RazaDTO> Listar_Raza(){
        String SQL = "EXECUTE usp_Listar_RAZAS";
        List<RazaDTO> Razas = new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement stm = CNX.prepareStatement(SQL);
            ResultSet resultado = stm.executeQuery()){
            while (resultado.next()){
                RazaDTO razaDTO = new RazaDTO();
                razaDTO.setID_Raza(resultado.getString("id_raza"));
                razaDTO.setNombre_Raza(resultado.getString("nombre_raza"));
                razaDTO.setID_Tipo_Mascota(resultado.getString("ID_Tipo_mascota"));
                Razas.add(razaDTO);
            }
        }catch (SQLException ErrorSQL) {
            System.out.println("Error de codigo Metodo Listar Razas: " + ErrorSQL);
        }
        return Razas;
    }

    public List<Tipo_MascotaDTO> Listar_Tipo_Mascota(){
        String SQL = "EXEC dbo.usp_Listar_TIPO_MASCOTA";
        List<Tipo_MascotaDTO> Tipos = new ArrayList<>();
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement stm = CNX.prepareStatement(SQL);
            ResultSet resultado = stm.executeQuery()){
            while (resultado.next()){
                Tipo_MascotaDTO tipoDTO = new Tipo_MascotaDTO();
                tipoDTO.setID_Tipo_Mascota(resultado.getString("id_tipo_mascota"));
                tipoDTO.setTipo_de_mascota(resultado.getString("tipo_mascota"));
                Tipos.add(tipoDTO);
            }
        }catch (SQLException ErrorSQL) {
            System.out.println("Error de codigo Metodo Listar Tipos: " + ErrorSQL);
        }
        return Tipos;
    }

}
