package com.example.demo.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.demo.csvreader.MiLectorCSV;
import com.example.demo.interfaces.IFiltros;
import com.example.demo.player.Player;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Player> jugadores = MiLectorCSV.getPlayers();

        //Consultar jugadores mayores a 34 años
        consultarPorEdad(jugadores);

        //Filtrar jugadores por club especifico
        consultarPorClub(jugadores);

        //Consultar Nacionalidades de los jugadores
        consultarNacionalidadPorNombre(jugadores);

        //Crear una lista de las nacionalidades
        crearListaNacionalidades(jugadores);

        //Ranking de los jugadores por cada pais
        generarRankingJugadores(jugadores);
    }

    private static void generarRankingJugadores(List<Player> jugadores) {
    }

    private static void crearListaNacionalidades(List<Player> jugadores) {
        IFiltros filtro;
        List<String> paises = new ArrayList<>();

        filtro = new IFiltros() {

            @Override
            public boolean comparacion(Player jugador) {
                
                if (paises.contains(jugador.getNational())){
                    return false;
                } else{
                    paises.add(jugador.getNational());
                    return true;
                }
            }
        };

        jugadores.forEach(jugador -> {
            filtro.comparacion(jugador);
        });

        paises.forEach(pais -> {
            System.out.println("Nacionalidad: " + pais);
        });
    }

    private static void consultarNacionalidadPorNombre(List<Player> jugadores) {
        IFiltros filtro;
        String nombre;
        List<Player> filtrados = new ArrayList<>();

        System.out.print("Ingrese el nombre del jugador a consultar: ");
        nombre = sc.nextLine();

        filtro = new IFiltros() {

            @Override
            public boolean comparacion(Player jugador) {
                
                if (jugador.getName().strip().toLowerCase().contains(nombre.strip().toLowerCase())){
                    return true;
                } else{
                    return false;
                }
            }
        };

        jugadores.forEach(jugador -> {
            if (filtro.comparacion(jugador)){
                filtrados.add(jugador);
            }
        });

        if (filtrados.size() < 1){
            System.out.println("No se encontraron jugadores con el nombre " + nombre);
        } else{
            filtrados.forEach(jugador -> {System.out.println(jugador.toString());});
        }
    }

    private static void consultarPorClub(List<Player> jugadores) {
        IFiltros filtro;
        String club;
        List<Player> filtrados = new ArrayList<>();

        System.out.print("\nIngrese el club a filtrar: ");
        club = sc.nextLine();

        filtro = new IFiltros() {

            @Override
            public boolean comparacion(Player jugador) {

                if (jugador.getClub().toLowerCase().strip().equals(club.toLowerCase().strip())){
                    return true;
                }
                return false;
            }
        };

        jugadores.forEach(jugador  -> {
            if (filtro.comparacion(jugador)){
                filtrados.add(jugador);
            }
        });
        
        if (filtrados.size() < 1){
            System.out.println("No se  encontró ningún jugador perteneciente al club " + club);
        } else{
            filtrados.forEach(jugador -> {System.out.println(jugador.toString());});
        }
        
    }

    private static void consultarPorEdad(List<Player> jugadores) {
        IFiltros filtro;

        int edad;

        List<Player> filtrados = new ArrayList<Player>();

        try{
            System.out.print("Ingrese la edad a filtrar: ");
            edad = Integer.parseInt(sc.nextLine());
        } catch(Exception ex){
            System.out.println("ERROR: solo se admiten números. Saliendo...");
            return;
        }

        if (edad < 15){
            System.out.println("ERROR: solo se consultan jugadores a partir de 15 años de edad");
            return;
        }


        filtro = new IFiltros(){

            @Override
            public boolean comparacion(Player jugador) {
                if (jugador.getAge() > edad){
                    return true;
                }
                return false;
            }
        };

        jugadores.forEach(jugador -> {
            if (filtro.comparacion(jugador)){
                filtrados.add(jugador);
            }
        });

        filtrados.forEach(jugador -> {System.out.println(jugador.toString());});
    }
    
}
