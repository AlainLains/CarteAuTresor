package services;

import models.Aventurier;
import models.Case;
import models.Coordonnees;

import java.util.List;

public class AventurierMouvementsService {

    public static Coordonnees turnLeft(Aventurier aventurier){
        Coordonnees nextAventurierPosition = new Coordonnees();
        switch (aventurier.getOrientation()) {
            case "N":
                System.out.println("L'aventurier se tourne du Nord vers l'Ouest");
                aventurier.setOrientation("O");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() - 1);
                break;
            case "O":
                System.out.println("L'aventurier se tourne de l'Ouest vers le Sud");
                aventurier.setOrientation("S");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() + 1);
                break;
            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Est");
                aventurier.setOrientation("E");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() + 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;
            case "E":
                System.out.println("L'aventurier se tourne de l'Est vers le Nord");
                aventurier.setOrientation("N");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() - 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;
        }
        return nextAventurierPosition;
    }

    public static Coordonnees turnRight(Aventurier aventurier){
        Coordonnees nextAventurierPosition = new Coordonnees();
        switch (aventurier.getOrientation()) {
            case "N":
                System.out.println("L'aventurier se tourne du Nord vers l'Est");
                aventurier.setOrientation("E");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() + 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;
            case "E":
                System.out.println("L'aventurier se tourne de l'Est vers le Sud");
                aventurier.setOrientation("S");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() + 1);

                break;
            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Ouest");
                aventurier.setOrientation("O");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() - 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());

                break;
            case "O":
                System.out.println("L'aventurier se tourne de l'Ouest vers le Nord");
                aventurier.setOrientation("N");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() - 1);

                break;


        }
        return nextAventurierPosition;
    }

    public static Coordonnees initializeNextAventurierPosition(Aventurier aventurier){
        Coordonnees nextAventurierPosition = new Coordonnees();
        switch(aventurier.getOrientation()){
            case "N":
                nextAventurierPosition = new Coordonnees(aventurier.getPosition().getPositionX(), aventurier.getPosition().getPositionY() - 1);
                break;
            case "O":
                nextAventurierPosition = new Coordonnees(aventurier.getPosition().getPositionX() - 1, aventurier.getPosition().getPositionY());
                break;
            case "S":
                nextAventurierPosition = new Coordonnees(aventurier.getPosition().getPositionX(), aventurier.getPosition().getPositionY() + 1);
                break;
            case "E":
                nextAventurierPosition = new Coordonnees(aventurier.getPosition().getPositionX() + 1, aventurier.getPosition().getPositionY());
                break;
        }
        return nextAventurierPosition;
    }

    public static void moveAventurier(Case[][] carte, Aventurier aventurier, Coordonnees taille){
        String mouvements = aventurier.getMouvements();
        char[] etapes = mouvements.toCharArray();

        int largeur = taille.getPositionX();
        int longueur = taille.getPositionY();

        Coordonnees currentAventurierPosition = aventurier.getPosition();
        Coordonnees nextAventurierPosition = initializeNextAventurierPosition(aventurier);


        for(int i=0; i<etapes.length; i++){

            switch (etapes[i]){
                case 'A':
                    if(nextAventurierPosition.getPositionX() >= 0 && nextAventurierPosition.getPositionY() >= 0
                    && nextAventurierPosition.getPositionX() <= largeur && nextAventurierPosition.getPositionY() <= longueur) {
                        Coordonnees tmp = new Coordonnees(nextAventurierPosition.getPositionX() - currentAventurierPosition.getPositionX(), nextAventurierPosition.getPositionY() - currentAventurierPosition.getPositionY());
                        currentAventurierPosition.setPositionX(nextAventurierPosition.getPositionX());
                        currentAventurierPosition.setPositionY(nextAventurierPosition.getPositionY());

                        aventurier.setPosition(currentAventurierPosition);

                        nextAventurierPosition.setPositionX(currentAventurierPosition.getPositionX() + tmp.getPositionX());
                        nextAventurierPosition.setPositionY(currentAventurierPosition.getPositionY() + tmp.getPositionY());

                        System.out.println("X après déplacement : " + aventurier.getPosition().getPositionX() + "\nY après déplacement : " + aventurier.getPosition().getPositionY());
                        checkPositionAventurier(carte, aventurier);

                    }
                    break;
                case 'D':
                    nextAventurierPosition = turnRight(aventurier);
                    break;
                case 'G':
                    nextAventurierPosition = turnLeft(aventurier);
                    break;
            }
        }
    }

    public static void checkPositionAventurier(Case[][] carte, Aventurier aventurier){
        int nbTresorsDansCase = carte[aventurier.getPosition().getPositionX()][aventurier.getPosition().getPositionY()].getNbTresors();

        if(nbTresorsDansCase > 0){
            System.out.println("Nombre de trésors de l'aventurier avant : " + aventurier.getNbTresors());
            carte[aventurier.getPosition().getPositionX()][aventurier.getPosition().getPositionY()].setNbTresors(nbTresorsDansCase - 1);
            aventurier.setNbTresors(aventurier.getNbTresors() + 1);
            System.out.println("Nombre de trésors de l'aventurier après : " + aventurier.getNbTresors());

        }
    }
}
