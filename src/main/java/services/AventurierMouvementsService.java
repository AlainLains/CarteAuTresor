package services;

import models.Aventurier;
import models.Case;

public class AventurierMouvementsService {
    public static void turnLeft(Aventurier aventurier){
        switch (aventurier.getOrientation()) {
            case "N":
                System.out.println("L'aventurier se tourne du Nord vers l'Ouest");
                aventurier.setOrientation("O");
                break;
            case "O":
                System.out.println("L'aventurier se tourne de l'Ouest vers le Sud");
                aventurier.setOrientation("S");
                break;
            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Est");
                aventurier.setOrientation("E");
                break;
            case "E":
                System.out.println("L'aventurier se tourne de l'Est vers le Nord");
                aventurier.setOrientation("N");
                break;
        }
    }

    public static void turnRight(Aventurier aventurier){
        switch (aventurier.getOrientation()) {
            case "N":
                System.out.println("L'aventurier se tourne du Nord vers Est");
                aventurier.setOrientation("E");
                break;
            case "O":
                System.out.println("L'aventurier se toure de l'Est vers le Sud");
                aventurier.setOrientation("S");
                break;
            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Ouest");
                aventurier.setOrientation("O");
                break;
            case "E":
                System.out.println("L'aventurier se toure de l'Ouest vers le Nord");
                aventurier.setOrientation("N");
                break;
        }
    }

    public static void goForward(Case[][] carte, Aventurier aventurier){

    }
}
