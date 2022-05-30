package services;

import models.Aventurier;
import models.Case;
import models.Coordonnees;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AventurierMouvementsServiceTest {

    @Test
    void initializeNextAventurierPosition() {
        Coordonnees c, nextAvPos;
        // Instanciation de la liste des coordonnées attendues
        List<Coordonnees> cList = new ArrayList<Coordonnees>();
        cList.add(new Coordonnees(1,0));
        cList.add(new Coordonnees(0,1));
        cList.add(new Coordonnees(1, 2));
        cList.add(new Coordonnees(2, 1));

        // Instanciation des aventuriers pour chaque cas du switch case
        Aventurier avNord = new Aventurier("Alain", "N", c = new Coordonnees(1,1), "ADGA");
        Aventurier avOuest = new Aventurier("Alain", "O", c = new Coordonnees(1,1), "ADGA");
        Aventurier avSud = new Aventurier("Alain", "S", c = new Coordonnees(1,1), "ADGA");
        Aventurier avEst = new Aventurier("Alain", "E", c = new Coordonnees(1,1), "ADGA");

        // Vérification du déplacement vers le Nord
        nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(avNord);
        assertEquals(cList.get(0).getPositionX(), nextAvPos.getPositionX());
        assertEquals(cList.get(0).getPositionY(), nextAvPos.getPositionY());

        // Vérification du déplacement vers l'Ouest
        nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(avOuest);
        assertEquals(cList.get(1).getPositionX(), nextAvPos.getPositionX());
        assertEquals(cList.get(1).getPositionY(), nextAvPos.getPositionY());

        // Vérification du déplacement vers le Sud
        nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(avSud);
        assertEquals(cList.get(2).getPositionX(), nextAvPos.getPositionX());
        assertEquals(cList.get(2).getPositionY(), nextAvPos.getPositionY());

        // Vérification du déplacement vers l'Est
        nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(avEst);
        assertEquals(cList.get(3).getPositionX(), nextAvPos.getPositionX());
        assertEquals(cList.get(3).getPositionY(), nextAvPos.getPositionY());
    }

    @Test
    void aventurierCanGoForward() {

        // Instanciation de l'aventurier
        Coordonnees c;
        Aventurier av = new Aventurier("Alain", "S", c = new Coordonnees(3,3), "A");
        Coordonnees initialAvPos = new Coordonnees(av.getPosition().getPositionX(), av.getPosition().getPositionY());

        // Génération de la carte
        Case[][] carte = new Case[5][5];
        for(int i=0; i< carte.length; i++){
            for(int j=0; j < carte[i].length; j++){
                carte[i][j] = new Case(i, j);
            }
        }

        AventurierMouvementsService.moveAventurier(carte, av);
        assertTrue(initialAvPos.getPositionX() != av.getPosition().getPositionX()
                || initialAvPos.getPositionY() != av.getPosition().getPositionY(),
                "Le déplacement n'est pas possible car il rencontre soit une montage, soit une limite " +
                        "de la carte.");


        /*assertTrue(nextAvPos.getPositionX() >= 0 && nextAvPos.getPositionY() >= 0 &&
                nextAvPos.getPositionX() < carte.length && nextAvPos.getPositionY() < carte[0].length,
                "La position de l'aventurier après le mouvement (" + nextAvPos.getPositionX() + "," +
                        nextAvPos.getPositionY() + ") ne doit pas sortir des limites de la carte (" +
                        carte.length + "," + carte[0].length + ").");*/

    }

    @Test
    void nextMoveNotOutOfBounds() {

        // Instanciation de l'aventurier
        Coordonnees c;
        Aventurier av = new Aventurier("Alain", "S", c = new Coordonnees(3,3), "A");
        Coordonnees nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(av);

        // Génération de la carte
        Case[][] carte = new Case[5][5];
        for(int i=0; i< carte.length; i++){
            for(int j=0; j < carte[i].length; j++){
                carte[i][j] = new Case(i, j);
            }
        }

        assertTrue(nextAvPos.getPositionX() >= 0 && nextAvPos.getPositionY() >= 0 &&
                nextAvPos.getPositionX() < carte.length && nextAvPos.getPositionY() < carte[0].length,
                "La position de l'aventurier après le mouvement (" + nextAvPos.getPositionX() + "," +
                        nextAvPos.getPositionY() + ") ne doit pas sortir des limites de la carte (" +
                        carte.length + "," + carte[0].length + ").");

    }

    @Test
    void nextMoveNotOnMountain(){
        // Instanciation de l'aventurier
        Coordonnees c;
        Aventurier av = new Aventurier("Alain", "S", c = new Coordonnees(3,2), "ADGA");
        Coordonnees currentAvPos = av.getPosition();
        Coordonnees nextAvPos = AventurierMouvementsService.initializeNextAventurierPosition(av);

        // Génération de la carte
        Case[][] carte = new Case[5][5];
        for(int i=0; i< carte.length; i++){
            for(int j=0; j < carte[i].length; j++){
                carte[i][j] = new Case(i, j);
            }
        }

        carte[3][4].setIsMontagne(true);

        assertTrue(carte[nextAvPos.getPositionX()][nextAvPos.getPositionY()].getIsMontagne() == false,
                "L'aventurier ne peut pas se rendre à la case (" + nextAvPos.getPositionX() + "," +
                        nextAvPos.getPositionY() + ") car une montagne s'y trouve.");
    }

}