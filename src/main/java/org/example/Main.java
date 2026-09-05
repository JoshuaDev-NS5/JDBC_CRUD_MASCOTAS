package org.example;
import org.example.DTOs.MascotaDTO;
import org.example.DTOs.MascotaListaDTO;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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