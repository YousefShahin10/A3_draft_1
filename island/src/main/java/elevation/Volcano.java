package elevation;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Vertex;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public class Volcano extends Elevation{
    private double centreX;
    private double centreY;
    private int layers;
    private double radius;
    private double maxElevation;

    public Volcano(double centreX, double centreY, int layers, double maxElevation){
        this.centreX = centreX;
        this.centreY = centreY;
        this.layers = layers;
        this.maxElevation = maxElevation;

        //set intial radius 100 as we want that much increatment of layers
        this.radius = 100;
    }

    public void createElevation(MyMesh mesh){
        for(int i = 0; i < layers; i++){
            for(MyPolygon mp : mesh.getPolygons()){
                List <Vertex> vs = new ArrayList<>();
    
                for(int segment : mp.getSegments()){
                    Segment seg = mesh.getSegments().get(segment);
    
                    vs.add(mesh.getVertexs().get(seg.getV1Idx()));
                    vs.add(mesh.getVertexs().get(seg.getV2Idx()));
                }
    
                boolean result = inside(vs);
                
                if(result){
                    mp.setElevation(maxElevation);
                }
            }

            this.maxElevation -= (this.maxElevation/this.layers);
        }
    }

    private boolean inside(List <Vertex> vs){
        boolean in = false, out = false;
        for(Vertex v : vs){
            double radius = findRadius(v.getX(), v.getY(), this.centreX, this.centreY);
            
            if(radius > this.radius){
                out = true;
            }

            if(radius < this.radius){
                in = true;
            }
        }

        if((in && out)){
            return true;
        }else{
            return false;
        }
    }

    private double findRadius(double x, double y, double centreX, double centreY){
        return Math.sqrt(Math.pow((x-centreX), 2) + Math.pow((y-centreY), 2));
    }
}
