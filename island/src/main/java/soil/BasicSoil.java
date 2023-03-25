package soil;

import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import colors.IslandColors;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class BasicSoil extends Soil{
    
    public void function(MyPolygon mp, MyMesh mesh){
        for(MyPolygon poly : mesh.getPolygons()){
            if(poly.getColor().equals(IslandColors.LAND)){
                double weight = 0;

                for(Vertex v : this.water){
                    weight += distance(v, mesh.getVertexs().get(poly.getCentroidId()));
                }
                
                weight*=0.1;

                poly.setSoilAbsorptionLevel(weight);
            }
        }
    }//end method function

    public double distance(Vertex v1, Vertex v2){
        return Math.sqrt((Math.pow((v1.getX() - v2.getX()), 2))+(Math.pow(v1.getY() - v2.getY(), 2)));
    }//end method distance
}//end of class