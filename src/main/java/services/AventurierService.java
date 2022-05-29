package services;

import models.Aventurier;

public abstract class AventurierService {

    public static void turnLeft(Aventurier aventurier){
        switch (aventurier.getOrientation()) {
            case "Nord":
                System.out.println("Nord --> Ouest");
                aventurier.setOrientation("Ouest");
                break;
            case "Ouest":
                System.out.println("Ouest --> Sud");
                aventurier.setOrientation("Sud");
                break;
            case "Sud":
                System.out.println("Sud --> Est");
                aventurier.setOrientation("Est");
                break;
            case "Est":
                System.out.println("Est --> Nord");
                aventurier.setOrientation("Nord");
                break;
        }
    }

    public static void turnRight(Aventurier aventurier){
        switch (aventurier.getOrientation()) {
            case "Nord":
                System.out.println("Nord --> Est");
                aventurier.setOrientation("Est");
                break;
            case "Ouest":
                System.out.println("Est --> Sud");
                aventurier.setOrientation("Sud");
                break;
            case "Sud":
                System.out.println("Sud --> Ouest");
                aventurier.setOrientation("Ouest");
                break;
            case "Est":
                System.out.println("Ouest --> Nord");
                aventurier.setOrientation("Nord");
                break;
        }
    }
}
