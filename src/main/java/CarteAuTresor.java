import models.Aventurier;
import models.Case;
import models.Coordonnees;
import services.AventurierService;
import services.CarteService;
import utils.ReadFile;

import javax.sound.sampled.Line;
import java.util.List;

public class CarteAuTresor {
    public static void main(String[] args) throws Exception {
        Aventurier av = new Aventurier("Alain", "Nord", new Coordonnees(0,0));
        AventurierService.turnRight(av);

        String filepath = args[0];

        List<String> rows = ReadFile.getFile(filepath);
        Case[][] carte = CarteService.createMap(rows);
    }
}
