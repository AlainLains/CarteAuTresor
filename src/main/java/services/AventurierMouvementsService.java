package services;

import models.Aventurier;
import models.Case;
import models.Coordonnees;

public class AventurierMouvementsService {

    /**
     * Fonction qui permet à l'aventurier de changer son orientation de 90° vers la gauche
     * @param aventurier
     * @return nextAventurierPosition = la future position de l'aventurier en fonction de son orientation s'il souhaite avancer.
     */
    public static Coordonnees turnLeft(Aventurier aventurier){
        Coordonnees nextAventurierPosition = new Coordonnees();
        switch (aventurier.getOrientation()) {
            case "N":
                System.out.println("L'aventurier se tourne du Nord vers l'Ouest.");
                aventurier.setOrientation("O");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() - 1);
                break;
            case "O":
                System.out.println("L'aventurier se tourne de l'Ouest vers le Sud.");
                aventurier.setOrientation("S");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() + 1);
                break;
            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Est.");
                aventurier.setOrientation("E");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() + 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;
            case "E":
                System.out.println("L'aventurier se tourne de l'Est vers le Nord.");
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
                System.out.println("L'aventurier se tourne du Nord vers l'Est.");
                aventurier.setOrientation("E");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() + 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;

            case "E":
                System.out.println("L'aventurier se tourne de l'Est vers le Sud.");
                aventurier.setOrientation("S");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() + 1);
                break;

            case "S":
                System.out.println("L'aventurier se tourne du Sud vers l'Ouest.");
                aventurier.setOrientation("O");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX() - 1);
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY());
                break;

            case "O":
                System.out.println("L'aventurier se tourne de l'Ouest vers le Nord.");
                aventurier.setOrientation("N");
                nextAventurierPosition.setPositionX(aventurier.getPosition().getPositionX());
                nextAventurierPosition.setPositionY(aventurier.getPosition().getPositionY() - 1);
                break;
        }
        return nextAventurierPosition;
    }

    /**
     * Permet de déterminer quelle sera la position de l'aventurier au prochain mouvement.
     * @param aventurier
     * @return nextAventurierPosition = la future position de l'aventurier en fonction de son orientation s'il souhaite avancer.
     */
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

    /**
     * Fonction qui permet à l'aventurier d'avancer si :
     *      - son mouvement se trouve dans les limites de la carte,
     *      - la position après son mouvement ne correspond pas à la position d'une montagne.
     * @param carte
     * @param aventurier
     * @return carte = l'état de la carte après les mouvements de l'aventurier
     */
    public static Case[][] moveAventurier(Case[][] carte, Aventurier aventurier){
        char[] etapes = aventurier.getMouvements().toCharArray();
        int largeur = carte.length;
        int longueur = carte[0].length;
        Coordonnees currentAventurierPosition = aventurier.getPosition();
        Coordonnees nextAventurierPosition = initializeNextAventurierPosition(aventurier);


        for(int i=0; i<etapes.length; i++){
            switch (etapes[i]){
                case 'A':
                    //Vérification pour éviter que l'aventurier ne soit en out of bounds
                    if(nextAventurierPosition.getPositionX() >= 0 && nextAventurierPosition.getPositionY() >= 0
                            && nextAventurierPosition.getPositionX() < largeur && nextAventurierPosition.getPositionY() < longueur) {

                        //Vérification pour que l'aventurier ne puisse pas aller sur une case montange
                        boolean isNextCaseMontagne = carte[nextAventurierPosition.getPositionX()][nextAventurierPosition.getPositionY()].getIsMontagne();

                        //Application du déplacement
                        if(!isNextCaseMontagne){
                            Coordonnees tmp = new Coordonnees(nextAventurierPosition.getPositionX() - currentAventurierPosition.getPositionX(), nextAventurierPosition.getPositionY() - currentAventurierPosition.getPositionY());
                            currentAventurierPosition.setPositionX(nextAventurierPosition.getPositionX());
                            currentAventurierPosition.setPositionY(nextAventurierPosition.getPositionY());

                            aventurier.setPosition(currentAventurierPosition);

                            nextAventurierPosition.setPositionX(currentAventurierPosition.getPositionX() + tmp.getPositionX());
                            nextAventurierPosition.setPositionY(currentAventurierPosition.getPositionY() + tmp.getPositionY());

                            System.out.println(aventurier.getName() + " avance vers la case (" + aventurier.getPosition().getPositionX() + "," +
                                    aventurier.getPosition().getPositionY() + ").");
                            checkPositionTresor(carte, aventurier);
                        }
                        else
                            System.out.println("L'aventurier ne peut pas accéder à la case ("+nextAventurierPosition.getPositionX()+","+nextAventurierPosition.getPositionY()+") à cause d'une chaîne de montagnes.");


                    }
                    else
                        System.out.println("L'aventurier souhaite avancer mais il ne peut pas sortir des limites de la carte. Mouvement annulé.\n");
                    break;

                case 'D':
                    nextAventurierPosition = turnRight(aventurier);
                    break;

                case 'G':
                    nextAventurierPosition = turnLeft(aventurier);
                    break;
            }
        }
        System.out.println("\nNombre de trésor(s) ramassé(s) : " + aventurier.getNbTresors());
        return carte;
    }


    /**
     * Fonction qui permet de vérifier si l'aventurier est tombé sur un trésor.
     * Si oui, incrémentation de son nombre de trésors et décrémentation du nombre de trésor de la case correspondante.
     * @param carte
     * @param aventurier
     */
    public static void checkPositionTresor(Case[][] carte, Aventurier aventurier){
        int nbTresorsDansCase = carte[aventurier.getPosition().getPositionX()][aventurier.getPosition().getPositionY()].getNbTresors();

        if(nbTresorsDansCase > 0){
            carte[aventurier.getPosition().getPositionX()][aventurier.getPosition().getPositionY()].setNbTresors(nbTresorsDansCase - 1);
            aventurier.setNbTresors(aventurier.getNbTresors() + 1);
            System.out.println("Il a trouvé un trésor ! -- Nombre de trésor(s) récupéré(s) : " + aventurier.getNbTresors() +"\n");
        }
    }


}
