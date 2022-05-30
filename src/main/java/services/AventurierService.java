package services;

import models.Aventurier;
import models.Coordonnees;

import java.util.List;

import static java.lang.Integer.parseInt;

public abstract class AventurierService {
    /**
     * Permet de créer un aventurier
     * @param rows
     * @return aventurier = l'aventurier saisi dans le fichier d'entrée
     * @throws NullPointerException
     */
    public static Aventurier createAventurier(List<String> rows) throws NullPointerException{
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
        if(aventurier.getName() == null) throw new NullPointerException("Aucun aventurier n'a été détecté dans le fichier d'entrée.");
        return aventurier;
    }
}
