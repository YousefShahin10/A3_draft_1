package aquifers;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import colors.IslandColors;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class AquiferGenerator {
    public void createAquifiers(MyMesh mesh, int numberOfAquifers){
        List <MyPolygon> landTiles = new ArrayList<>();

        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAND)){
                landTiles.add(mp);
            }
        }

        for(int i = 0; i < numberOfAquifers; i++){
            int target = randomIsland(landTiles.size());

            MyPolygon aquifer = landTiles.get(target);


            for(int neighbour : aquifer.getNeighbours()){
                if(mesh.getPolygons().get(neighbour).getColor().equals(IslandColors.LAND)){
                    mesh.getPolygons().get(neighbour).increaseHumidity();
                }
            }

            landTiles.remove(aquifer);
        }
    }

    private int randomIsland(int numberOfLand){
        Random bag = new Random();

        return bag.nextInt(numberOfLand);
    }
}
