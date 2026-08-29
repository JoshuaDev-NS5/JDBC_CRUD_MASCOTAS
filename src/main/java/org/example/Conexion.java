package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    //Declaramos atributos de clases
    private static String url=
            "jdbc:sqlserver://localhost:1433;databaseName=SISTEM_VETERINARIA;encrypt=true;trustServerCertificate=true";
    private static final String user = "sa";
    private static final String clave= "1421";

    public static Connection obtenerConexion(){
        Connection cnx=null;
        try {
            cnx= DriverManager.getConnection(url,user,clave);
        }catch (SQLException ErrorSQL){
            System.out.println("Error de JDBC sqlServer (clase connexion): " + ErrorSQL );
        }

        return cnx;
    }

}
