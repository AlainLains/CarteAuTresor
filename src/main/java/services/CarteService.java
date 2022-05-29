package services;

import models.Case;
import models.Coordonnees;

import java.util.List;

import static java.lang.Integer.parseInt;

public abstract class CarteService {

    public static Case[][] createMap(List<String> rows){

        Case[][] carte = generateMap(rows);
        fillMap(carte, rows);

        return carte;
    }

    public static Case[][] generateMap(List<String> rows){


        Coordonnees taille = getMapSize(rows);
        int largeur = taille.getPositionX();
        int longueur = taille.getPositionY();
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
            String[] rowsplit = row.split(" - ");
            switch (rowsplit[0]){
                case "M":
                    System.out.println(row);
                    int x = parseInt(rowsplit[1]);
                    int y = parseInt(rowsplit[2]);
                    carte[x][y].setIsMontagne(true);
                    carte[x][y].setNbTresors(0);
                    break;

                case "T":
                    System.out.println(row);
                    x = parseInt(rowsplit[1]);
                    y = parseInt(rowsplit[2]);
                    int nbTresors = Character.getNumericValue(row.charAt(12));
                    carte[x][y].setIsMontagne(false);
                    carte[x][y].setNbTresors(nbTresors);
                    break;
            }

        }
    }

    public static Coordonnees getMapSize(List<String> rows){
        int largeur = 0, longueur = 0;
        for(String row : rows) {
            String[] rowsplit = row.split(" - ");
            if(rowsplit[0].equals("C")){
                largeur = parseInt(rowsplit[1]);
                longueur = parseInt(rowsplit[2]);
            }
        }
        return new Coordonnees(largeur, longueur);
    }

    public static Case[][] getMap(List<String> rows){
        return createMap(rows);
    }


}
