package com.example.demo;

import com.example.demo.player.Player;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvUtilFile {
    private CsvUtilFile(){}

    public static List<Player> getPlayers(){
        var uri =  CsvUtilFile.class.getClassLoader().getResource("src/files/data.csv");
        List<Player> list = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(uri.getFile()));
            List<String[]> registers = reader.readAll();
            registers.forEach(strings -> list.add(new Player(
                    (strings[0].trim()),
                    strings[1],
                    (Optional.of(strings[2].trim()).filter(h -> !h.isBlank()).orElse("0")),
                    strings[3],
                    strings[4],
                    (strings[5].trim()),
                    (strings[6].trim()),
                    strings[7]
            )));

           return list;

        } catch (IOException | CsvException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
