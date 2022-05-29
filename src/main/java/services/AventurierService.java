package services;

import models.Aventurier;
import models.Coordonnees;

import java.util.List;

import static java.lang.Integer.parseInt;

public abstract class AventurierService {

    public static Aventurier createAventurier(List<String> rows) throws Exception{
        Aventurier aventurier = new Aventurier();
        for(String row : rows) {
            String[] rowsplit = row.split(" - ");
            if(rowsplit[0].equals("A")){
                aventurier.setName(rowsplit[1]);
                aventurier.setOrientation(rowsplit[4]);
                aventurier.setPosition(new Coordonnees(parseInt(rowsplit[2]), parseInt(rowsplit[3])));
                aventurier.setMouvements(rowsplit[5]);
            }
        }

        return aventurier;
    }
}
