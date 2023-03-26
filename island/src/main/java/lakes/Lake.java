package lakes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import colors.IslandColors;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class Lake {
    public void createLakes(MyMesh mesh, int numberOfLakes, int seed){
        List <MyPolygon> landTiles = new ArrayList<>();

        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAND)){
                landTiles.add(mp);
            }
        }

        for(int i = 0; i < numberOfLakes; i++){
            int target = randomIsland(landTiles.size(), seed);
            int size = lakeSize();

            MyPolygon lake = landTiles.get(target);

            lake.setColor(IslandColors.LAKE);

            for(int j = 0; j < size; j++){
                for(int neighbour : lake.getNeighbours()){
                    if(mesh.getPolygons().get(neighbour).getColor().equals(IslandColors.LAND)){
                        mesh.getPolygons().get(neighbour).setColor(IslandColors.LAKE);
                        break;
                    }
                }
            }

            landTiles.remove(lake);
        }
    }

    private int randomIsland(int numberOfLand, int seed){
        Random bag = new Random();

        if(seed != -1){
            bag.setSeed(seed);
        }

        return bag.nextInt(numberOfLand);
    }

    private int lakeSize(){
        Random bag = new Random();

        return bag.nextInt(3);
    }
}
