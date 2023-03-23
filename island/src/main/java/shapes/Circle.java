package shapes;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class Circle extends Shape{
    private double radius; 

    public Circle(double radius, double centerX, double centerY){
        this.radius = radius;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void draw(MyMesh mesh){
        for(MyPolygon mp : mesh.getPolygons()){
            List <Vertex> vs = new ArrayList<>();

            for(int segment : mp.getSegments()){
                Segment seg = mesh.getSegments().get(segment);

                vs.add(mesh.getVertexs().get(seg.getV1Idx()));
                vs.add(mesh.getVertexs().get(seg.getV2Idx()));
            }

            int result = inside(vs);

            if(result == 0 && this.borderColor != null){
                mp.setColor(this.borderColor );
            }else if(result == 1 && this.outsideColor != null){
                mp.setColor(this.outsideColor);
            }else if(result == -1 && this.insideColor != null){
                mp.setColor(this.insideColor);
            }
        }
    }

    private double findRadius(double x, double y, double centreX, double centreY){
        return Math.sqrt(Math.pow((x-centreX), 2) + Math.pow((y-centreY), 2));
    }

    private int inside(List <Vertex> vs){
        boolean in = false, out = false;
        for(Vertex v : vs){
            double radius = findRadius(v.getX(), v.getY(), this.centerX, this.centerY);
            
            if(radius > this.radius){
                out = true;
            }

            if(radius < this.radius){
                in = true;
            }
        }

        if((in && out)){
            return 0;
        }else if(in){
            return -1;
        }else{
            return 1; 
        }
    }
}
