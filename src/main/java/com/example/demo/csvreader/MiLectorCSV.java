package com.example.demo.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.player.Player;

public class MiLectorCSV {

    
    public static List<Player> getPlayers(){
        
        BufferedReader br = null;
        List<Player> jugadores = new ArrayList<Player>();
        Player jugador;

        try {

            br = new BufferedReader(new FileReader("src/files/data.csv"));
            String line = br.readLine();
            while (null != line) {
                String[] fields = line.split(",");
                //System.out.println(Arrays.toString(fields));

                line = br.readLine();

                jugador = new Player(fields[0], //id
                                     fields[1], //Nombre
                                     fields[2], //Edad
                                     fields[3], //¿Icon?
                                     fields[4], //Nacionalidad
                                     fields[5], //Ganadores
                                     fields[6], //Juegos
                                     fields[7]); //Club
                jugadores.add(jugador);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jugadores;
    }
    
}
