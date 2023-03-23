package modes;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import shapes.Circle;

import meshcomponents.MyMesh;

public class Lagoon {
    private double radius = 200;

    public void generate(MyMesh mesh){
        Circle circle = new Circle(radius, mesh.getApproxCenterX(), mesh.getApproxCenterY());
        
        circle.setBorderColor(new Color(255, 217, 150));
        circle.setInsideColor(new Color(174, 187, 252));

        circle.draw(mesh);
    }  
}
