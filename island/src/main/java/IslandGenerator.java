import java.util.Map;

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
            Circle circle = new Circle(400, mesh.getApproxCenterX(), mesh.getApproxCenterY());
        
            circle.setBorderColor(new Color(255, 217, 150));
            circle.setInsideColor(new Color(40, 168, 17));
            circle.setOutsideColor(new Color(92, 74, 255));

            circle.draw(mesh);
        }else{
            Circle circle = new Circle(400, mesh.getApproxCenterX(), mesh.getApproxCenterY());
        
            circle.setBorderColor(new Color(255, 217, 150));
            circle.setInsideColor(new Color(40, 168, 17));
            circle.setOutsideColor(new Color(92, 74, 255));

            circle.draw(mesh);
        }

        if(configuration.get("mode").equals("lagoon")){
            Lagoon lagoonIsland = new Lagoon();
            lagoonIsland.generate(mesh);
        }
    }
}
