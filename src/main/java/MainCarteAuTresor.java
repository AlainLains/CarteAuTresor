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
        Coordonnees mapsize = CarteService.getMapSize(rows);

        Aventurier aventurier = AventurierService.createAventurier(rows);
        Case[][] map = CarteService.createMap(rows);
        Case[][] finalmap = AventurierMouvementsService.moveAventurier(map, aventurier, mapsize);

        WriteFile.writeResult(finalmap, aventurier);
    }
}
