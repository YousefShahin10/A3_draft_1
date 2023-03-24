import java.util.Map;

import colors.IslandColors;
import lakes.Lake;
import meshcomponents.MyMesh;
import modes.Lagoon;

import shapes.Circle;

import java.awt.Color;

public class IslandGenerator {
    private Map<String, String> configuration;

    public IslandGenerator(Map<String, String> configuration){
        this.configuration = configuration;
    }

    public void generate(MyMesh mesh) {
        if(configuration.get("shape").equals("circle")){
            Circle circle = new Circle(600, mesh.getApproxCenterX(), mesh.getApproxCenterY());
        
            circle.setBorderColor(IslandColors.BEACH);
            circle.setInsideColor(IslandColors.LAND);
            circle.setOutsideColor(IslandColors.OCEAN);

            circle.draw(mesh);
        }else{
            Circle circle = new Circle(600, mesh.getApproxCenterX(), mesh.getApproxCenterY());
        
            circle.setBorderColor(IslandColors.BEACH);
            circle.setInsideColor(IslandColors.LAND);
            circle.setOutsideColor(IslandColors.OCEAN);

            circle.draw(mesh);
        }

        if(configuration.get("mode").equals("lagoon")){
            Lagoon lagoonIsland = new Lagoon();
            lagoonIsland.generate(mesh);

            if(!configuration.get("lakes").isEmpty()){
                Lake lake = new Lake();

                lake.createLakes(mesh, Integer.parseInt(configuration.get("lakes")));
            }
        }else{
            //custom island
        }
    }
}
