package services;

import models.Case;
import models.Coordonnees;

import java.util.List;

public abstract class CarteService {

    public static Case[][] createMap(List<String> rows){

        Case[][] carte = generateMap(rows);
        fillMap(carte, rows);

        return carte;
    }

    public static Case[][] generateMap(List<String> rows){
        int largeur = Character.getNumericValue(rows.get(0).charAt(4));
        int longueur = Character.getNumericValue(rows.get(0).charAt(8));
        Case[][] carte = new Case[largeur][longueur];

        for(int i=0; i<largeur; i++){
            for(int j=0; j<longueur; j++){
                carte[i][j] = new Case(i,j);
            }
        }

        return carte;
    }

    public static void fillMap(Case[][] carte, List<String> rows){

        for(String row : rows){
            char firstChar = row.charAt(0);
            switch (firstChar){
                case 'M':
                    System.out.println(row);
                    int x = Character.getNumericValue(row.charAt(4));
                    int y = Character.getNumericValue(row.charAt(8));
                    carte[x][y].setIsMontagne(true);
                    carte[x][y].setNbTresors(0);
                    break;

                case 'T':
                    System.out.println(row);
                    x = Character.getNumericValue(row.charAt(4));
                    y = Character.getNumericValue(row.charAt(8));
                    int nbTresors = Character.getNumericValue(row.charAt(12));
                    carte[x][y].setIsMontagne(false);
                    carte[x][y].setNbTresors(nbTresors);
                    break;
            }

        }
    }


}
