import models.Aventurier;
import models.Case;
import models.Coordonnees;
import services.AventurierMouvementsService;
import services.AventurierService;
import services.CarteService;
import utils.ReadFile;

import javax.sound.sampled.Line;
import java.util.List;

public class CarteAuTresor {
    public static void main(String[] args) throws Exception {

        String filepath = args[0];
        List<String> rows = ReadFile.getFile(filepath);

        Aventurier av = AventurierService.createAventurier(rows);
        Case[][] carte = CarteService.createMap(rows);

        System.out.println(av.getMouvements());
        AventurierMouvementsService.moveAventurier(carte, av);
    }
}
