import models.Aventurier;
import models.Case;
import models.Coordonnees;
import services.AventurierMouvementsService;
import services.AventurierService;
import services.CarteService;
import utils.ReadFile;
import utils.WriteFile;

import java.util.List;

public class MainCarteAuTresor {
    public static void main(String[] args) throws Exception {


        List<String> rows = ReadFile.getFile(args[0]);
        Aventurier aventurier = AventurierService.createAventurier(rows);
        Case[][] map = CarteService.createMap(rows);

        System.out.println("------ Début de l'aventure ! ------\n");
        Case[][] finalmap = AventurierMouvementsService.moveAventurier(map, aventurier);
        System.out.println("------ Fin de l'aventure ! ------\n");

        WriteFile.writeResult(finalmap, aventurier);
    }
}
