package org.example;
import org.example.DTOs.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

//TIP Para <b>ejecutar</b> el código, pulsar <shortcut actionId="Run"/> o
// Haz clic en el ícono <icon src="AllIcons.Actions.Execute"/> del margen.
public class Main {
    public static void main(String[] args) {
        MascotaDAO Logica = new MascotaDAO();
        Scanner sc=new Scanner(System.in);
        boolean Salir = false;
        System.out.println("================");
        System.out.println("CRUD PERSONAS");
        System.out.println("================");
        while (!Salir){
            System.out.println("1) Ver todas las mascotas");
            System.out.println("2) Consultar sobre una mascota");
            System.out.println("3) Agregar una mascota ");
            System.out.println("4) Editar una mascota ");
            System.out.println("5) Eliminar una mascota ");
            System.out.println("0) Salir del sistema ");
            System.out.println("Seleccione una opccion: ");
            int option = -1;
            try {
                option = sc.nextInt();
            }catch (Exception es){
                System.out.println("Error: debe ingresar un numero entero.");
                sc.nextLine();//Limpiamos el contenido del scan
                continue;//Reinicia el bucle
            }

            sc.nextLine();
            if (option < 0 || option > 5) {//Evitamos que la opcion salga del rango de 0:5
                System.out.println("Opcion fuera de rango.");
                continue;//Saltamos todas las opciones y reiniciamos el bucle
            }
            switch (option){
                case 1:

                    List<MascotaListaDTO> Mascotas = Logica.ListarMascotas();
                    for(MascotaListaDTO M : Mascotas){
                        System.out.println(M.getID_Mascota() + " | " + M.getNombre()+ " | " + M.getGenero() + " | " + M.getEdad() +
                                M.getPeso() + " | " + M.getEstado() + " | " + M.getTipo_Mascota() + " | " + M.getCliente());

                    }
                    break;
                case 2:
                    try {
                        while (true){
                            System.out.println("Ingrese el ID de la mascota que desa consultar (MAS000):");
                            String ID = null;
                            ID=sc.nextLine();
                            if(ID.matches("MAS[0-9]{3}")){
                                System.out.println("Id Valido");
                                MascotaDTO Consulta= Logica.ConsultarMascota(ID);
                                if(Consulta==null){
                                    System.out.println("El ID buscado no tiene ninguna mascota seleccionada");
                                    continue;
                                }
                                else {
                                    System.out.println("Si existe mascota");
                                    System.out.println(Consulta.getID_Mascota() + " | " + Consulta.getNombre()+ " | " +
                                            Consulta.getGenero() + " | " + Consulta.getFecha_de_nacimiento() + " | " +
                                            Consulta.getEdad() + " | " + Consulta.getPeso() + " | " +
                                            Consulta.getEstado() + " | " + Consulta.getRaza() + " | " +
                                            Consulta.getTipo_Mascota() + " | " + Consulta.getCliente());
                                }
                            }else {
                                System.out.println("El Id dado no cumple con la estructura solicitada solicitado");
                                continue;
                            }
                            System.out.println("Termina el bucle");
                            break;

                        }
                    }catch (Exception error){
                        System.out.println("Error en la consulta por una mascota" + error);
                    }

                case 3:
                    try {
                        //Llamamos a las listas de id fuera del while para evitar llamar varias veces durante el bucle
                        // a la base de datos
                        List<EstadoDTO> Estados= Logica.Listar_Estado();
                        List<RazaDTO> Razas=Logica.Listar_Raza();
                        List<Tipo_MascotaDTO> Tipos=Logica.Listar_Tipo_Mascota();
                        List<ClienteDTO> Clientes=Logica.Lisatar_Clientes();
                        if(Tipos==null){
                            System.out.println("Tipos esta vacio");
                        }
                        MascotaTablaDTO M= new MascotaTablaDTO();
                        while (true){
                            System.out.println("Para agregar una mascota se te proporcionara los ID Necesarios" + "\n" );
                            System.out.println("Datos de Estado:-----------------------------");
                            System.out.println("| ID_Estado | Estado |");
                            for(EstadoDTO EST : Estados){
                                System.out.println(" | " + EST.getID_Estado() + " | " + EST.getEstado() + " | ");
                            }
                            System.out.println("Ingrese el estado:");
                            String Estado= sc.nextLine();
                            if (Estado.matches("EST[0-9]{3}")){
                                M.setID_Estado(Estado);
                            }else {
                                System.out.println("El Id dado no cumple con la estructura solicitada solicitado");
                                continue;
                            }
                            /*Solicitamos el dato de Raza --------------------*/
                            System.out.println("\n");
                            System.out.println("Datos de Razas:-----------------------------");
                            System.out.println("| ID_Raza | Nombre |");
                            for(RazaDTO RAZ : Razas){
                                System.out.println(" | " + RAZ.getID_Raza() + " | " + RAZ.getNombre_Raza() + " | ");
                            }
                            System.out.println("\n");
                            System.out.println("Ingrese la Raza:");
                            String Raza= sc.nextLine();
                            if (Raza.matches("RAZ[0-9]{3}")){
                                M.setID_Raza(Raza);
                            }else {
                                System.out.println("El Id dado no cumple con la estructura solicitada solicitado");
                                continue;
                            }
                            /*Ingresando el tipo de mascotas ---------------------*/
                            System.out.println("\n");
                            System.out.println("Datos de Tipos de Mascotas:-----------------------------");
                            System.out.println("| ID_Tipo de Mascota | Tipo de mascota |");
                            for(Tipo_MascotaDTO TIP : Tipos){
                                System.out.println(" | " + TIP.getID_Tipo_Mascota() + " | " + TIP.getTipo_de_mascota()+ " | ");
                            }

                            System.out.println("\n");
                            System.out.println("Ingrese el tipo:");
                            String TM= sc.nextLine();
                            if (TM.matches("TIP[0-9]{3}")){
                                M.setID_Tipo_Mascota(TM);
                            }else {
                                System.out.println("El Id dado no cumple con la estructura solicitada solicitado");
                                continue;
                            }

                            /*Ingresar el nombre de mascota ---------------*/
                            System.out.println("\n");
                            System.out.println("Ingresa el nombre de la mascota");
                            String Nombre=sc.nextLine();
                            if(Nombre.matches("[a-zA-Z]+")) {//Validamos que sea una palabra alfabetica
                                M.setNombre(Nombre);
                            }else {
                                System.out.println("Se ingreso un nombre invalido, solo se permiten letras");
                                continue;
                            }
                            /*Ingresar Fecha de nacimineto-------------*/
                            System.out.println("\n");
                            System.out.println("Ingresar la fecha de nacimiento AÑO-MES-DIA");
                            String Fecha_Nacimiento=sc.nextLine();
                            if(Fecha_Nacimiento.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")){
                                M.setFecha_de_nacimiento(Fecha_Nacimiento);
                            }else {
                                System.out.println("Se ingreso una fecha invalida, solo se permiten con el formato indicado");
                                continue;
                            }

                            /*Ingresar Peso*/
                            System.out.println("\n");
                            System.out.println("Ingresar el peso de la mascota");
                            Double Peso=sc.nextDouble();
                            if(Peso>=0.0){
                                M.setPeso(Peso);
                            }else {
                                System.out.println("Se ingreso un peso erroneo, solo se permiten pesos mayores a 0");
                                continue;
                            }

                            /*Ingresar Clientes---------------------------------------*/
                            System.out.println("\n");
                            System.out.println("Datos de Cliente:-----------------------------");
                            System.out.println("| ID_Cliente | Nombre | DNI |");
                            for(ClienteDTO CLI : Clientes){
                                System.out.println(" | " + CLI.getID_Cliente()+ " | " + CLI.getNombreCompleto() + " | " + CLI.getDNI()+ " | ");
                            }
                            System.out.println("\n");
                            System.out.println("Ingrese el cliente (CLI000):");
                            sc.nextLine();
                            String ClienteID= sc.nextLine();
                            if (ClienteID.matches("CLI[0-9]{3}")){
                                M.setID_Cliente(ClienteID);
                            }else {
                                System.out.println("El Id dado no cumple con la estructura solicitada solicitado");
                                continue;
                            }

                            /*Ingresar Peso*/
                            System.out.println("\n");
                            System.out.println("Ingresar el genero de la mascota (M/H)");
                            String Genero=sc.nextLine();
                            if(Genero.equals("M")  ||  Genero.equals("H") ){
                                M.setGenero(Genero);
                            }else {
                                System.out.println("Se ingreso un Genero erroneo,");
                                continue;
                            }
                            M.setFoto(null);
                            LocalDate Fecha_actual= LocalDate.now();
                            M.setFec_Registro(Fecha_actual.toString());
                            M.setUsu_Registrado("Admin");
                            M.setFec_ULT_MOD(Fecha_actual.toString());
                            M.setUse_utl_mod("Admin");


                            System.out.println(M.toString());
                            Logica.Insertar(M);


                            break;


                        }
                    }catch (Exception error){
                        System.out.println("Error en el registro por mascota: " + error);
                    }
                    break;

                case 4:

                    break;

                case 5:
                    break;

                case 0:
                    Salir = true;
                    System.out.println("Servicio terminado");
                    break;
            }
        }

    }
}