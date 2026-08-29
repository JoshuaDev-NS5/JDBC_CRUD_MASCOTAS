package org.example;
import org.example.Mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MascotaDAO {
    //Esta clase nos permitira almacenar la logica de cada consulta

    //Metodo que devuelve una lista de mascotas
    public List<Mascota> ListarMascotas(){
        String SQL = "EXEC dbo.usp_Listar_MASCOTAS";
        try(Connection CNX = Conexion.obtenerConexion();
            PreparedStatement ps = CNX.prepareStatement(SQL)){



        }catch (SQLException ErrorSQL ) {

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
