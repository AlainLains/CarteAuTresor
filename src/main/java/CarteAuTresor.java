import models.Aventurier;
import models.Case;
import models.Coordonnees;
import services.AventurierMouvementsService;
import services.AventurierService;
import services.CarteService;
import utils.ReadFile;
import utils.WriteFile;

import javax.sound.sampled.Line;
import java.util.List;

public class CarteAuTresor {
    public static void main(String[] args) throws Exception {

        String filepath = args[0];
        List<String> rows = ReadFile.getFile(filepath);
        Coordonnees tailleCarte = CarteService.getMapSize(rows);

        Aventurier av = AventurierService.createAventurier(rows);
        Case[][] carte = CarteService.createMap(rows);

        AventurierMouvementsService.moveAventurier(carte, av, tailleCarte);

        WriteFile.writeResult();
    }
}
