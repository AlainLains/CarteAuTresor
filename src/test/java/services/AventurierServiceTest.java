package services;

import models.Aventurier;
import models.Coordonnees;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AventurierServiceTest {

    @Test
    void createAventurier(){
        Coordonnees c;
        Aventurier av = new Aventurier("Alain",
                "N",
                 c = new Coordonnees(0,0),
                "ADGA");

        assertEquals("Alain", av.getName());
        assertEquals("N", av.getOrientation());
        assertEquals(c, av.getPosition());
        assertEquals(0, av.getNbTresors());
        assertEquals("ADGA", av.getMouvements());

    }

}