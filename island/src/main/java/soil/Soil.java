package soil;

import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

import java.util.List;
import java.util.Map;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import colors.IslandColors;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Soil {
    List <Vertex> water;

    public void createComposition(MyMesh mesh){
        this.water = findWater(mesh);

        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAND)){
                function(mp, mesh);
            }
        }
    }

    private List<Vertex> findWater(MyMesh mesh) {
        List <Vertex> waterLocations = new ArrayList<>();

        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAKE) || mp.isAquifier()){
                waterLocations.add(mesh.getVertexs().get(mp.getCentroidId()));
            }
        }

        return waterLocations;
    }

    public abstract void function(MyPolygon mp, MyMesh mesh);
}
