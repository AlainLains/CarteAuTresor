package models;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

public class Aventurier {

    private String nom;
    private String orientation;
    private Coordonnees position;
    private int nbTresors;

    public Aventurier (){

    }

    public Aventurier(String nom, String orientation, Coordonnees position){
        this.nom = nom;
        this.orientation = orientation;
        this.position = position;
        this.nbTresors = 0;
    }

    public String getName() {
        return nom;
    }

    public void setName(String name) {
        this.nom = name;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Coordonnees getPosition() {
        return position;
    }

    public void setPosition(Coordonnees position) {
        this.position = position;
    }





}
