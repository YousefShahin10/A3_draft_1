package aquifers;

import java.util.List;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import colors.IslandColors;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class AquiferGenerator {
    public void createAquifiers(MyMesh mesh, int numberOfAquifers, int seed){
        List <MyPolygon> landTiles = new ArrayList<>();

        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAND)){
                landTiles.add(mp);
            }
        }

        for(int i = 0; i < numberOfAquifers; i++){
            int target = randomIsland(landTiles.size(), seed);

            MyPolygon aquifer = landTiles.get(target);

            aquifer.setAquifier(true);

            // aquifer.setColor(Color.DARK_GRAY);

            landTiles.remove(aquifer);
        }
    }

    private int randomIsland(int numberOfLand, int seed){
        Random bag = new Random();

        if(seed != -1){
            bag.setSeed(seed);
        }

        return bag.nextInt(numberOfLand);
    }
}
