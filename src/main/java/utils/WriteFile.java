package utils;

import models.Aventurier;
import models.Case;
import models.Coordonnees;
import services.CarteService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFile {
    public static void writeResult(Case[][] finalmap, Aventurier aventurier) {
        try {
            File result = new File("result2.txt");

            if (result.createNewFile()) {
                System.out.println("File created: " + result.getName());
                FileWriter myWriter = new FileWriter("result2.txt");

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
