package models;

public class Case {

    private Coordonnees position;
    private boolean isMontagne;
    private int nbTresors;

    public Case() {
        this.isMontagne = false;
        this.nbTresors = 0;
    }

    public Case(int largeur, int longueur){
        this.position = new Coordonnees(largeur, longueur);
        this.isMontagne = false;
        this.nbTresors = 0;
    }

    public Case(Coordonnees position, boolean isMontagne, int nbTresors) {
        this.position = position;
        this.isMontagne = isMontagne;
        this.nbTresors = nbTresors;
    }

    public Coordonnees getPosition() {
        return position;
    }

    public void setPosition(Coordonnees position) {
        this.position = position;
    }

    public boolean isMontagne() {
        return isMontagne;
    }

    public void setIsMontagne(boolean montagne) {
        isMontagne = montagne;
    }

    public int getNbTresors() {
        return nbTresors;
    }

    public void setNbTresors(int nbTresors) {
        this.nbTresors = nbTresors;
    }


}
