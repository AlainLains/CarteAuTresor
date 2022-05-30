package utils;

import models.Aventurier;
import models.Case;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    /**
     * Fonction qui permet d'écrire dans un fichier .txt le suivi de l'aventure.
     * @param finalmap
     * @param aventurier
     */
    public static void writeResult(Case[][] finalmap, Aventurier aventurier) {
        try {
            File result = new File("journal_de_bord.txt");

            if (result.createNewFile()) {
                System.out.println("File created: " + result.getName());
                FileWriter myWriter = new FileWriter("journal_de_bord.txt");

                List<String> data = getAllFinalData(finalmap, aventurier);
                for(int i=0; i<data.size(); i++){
                    myWriter.write(data.get(i));
                }
                myWriter.close();
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Fonction qui permet de récupérer toutes les données une fois que l'avventure terminée.
     * @param finalmap
     * @param aventurier
     * @return data = Le contenu du fichier de sortie.
     */
    public static List<String> getAllFinalData(Case[][] finalmap, Aventurier aventurier){

        List<String> data = new ArrayList<String>();
        data.add("C - " + finalmap.length + " - " + finalmap[0].length + "\n");
        for(int i=0; i<finalmap.length; i++){
            for(int j=0; j<finalmap[i].length; j++){
                if(finalmap[i][j].getIsMontagne()){
                    data.add("M - " + finalmap[i][j].getPosition().getPositionX() + " - " + finalmap[i][j].getPosition().getPositionY() + "\n");
                }
            }
        }
        data.add("# {T comme Trésor} - {Axe horizontal} - {Axe vertical} - {Nb. de trésors restants}\n");
        for(int i=0; i<finalmap.length; i++){
            for(int j=0; j<finalmap[i].length; j++){
                if(finalmap[i][j].getNbTresors() > 0){
                    data.add("T - " + finalmap[i][j].getPosition().getPositionX() + " - " + finalmap[i][j].getPosition().getPositionY() + " - " +
                            finalmap[i][j].getNbTresors() + "\n");
                }
            }
        }
        data.add("# {A comme Aventurier} - {Nom de l’aventurier} - {Axe horizontal} - {Axe vertical} - {Orientation} - {Nb. trésors ramassés}\n");
        data.add("A - " + aventurier.getName() + " - " + aventurier.getPosition().getPositionX() + " - " + aventurier.getPosition().getPositionY() +
                        " - " + aventurier.getOrientation() + " - " + aventurier.getNbTresors());

        return data;
    }
}
