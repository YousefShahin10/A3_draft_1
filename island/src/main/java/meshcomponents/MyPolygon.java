package meshcomponents;
import java.util.List;
import ca.mcmaster.cas.se2aa4.a2.io.Structs.Segment;
import java.awt.Color;

public class MyPolygon {
    private List <Integer> neighbours;
    private Color color; 
    private int id; 
    private List <Integer> segments;
    private int centroidId;
    private double elevation;
    private double humidity;
    private double soilAbsorptionLevel;
    private boolean aquifer;


    public MyPolygon (){
        //default value is at sea Level
        this.elevation = 0;

        //default humidity in room is 30%
        this.humidity = 0.3;

        //default water level in soil
        this.soilAbsorptionLevel = 0.25;

        //not a aquifier
        aquifer = false;
    }

    public boolean isAquifier(){
        return this.aquifer;
    }

    public void setAquifier(boolean aquifier){
        this.aquifer = aquifier;
    }

    public void setSoilAbsorptionLevel(double soilAbsorptionLevel){
        if(this.soilAbsorptionLevel < 1)this.soilAbsorptionLevel += soilAbsorptionLevel;
    }

    public double getSoilAbsorptionLevel(){
        return this.soilAbsorptionLevel;
    }

    public void increaseHumidity(){
        if(this.humidity < 1)this.humidity += 0.05;
    }

    public double getHumidity(){
        return this.humidity;
    }

    public void setElevation(double elevation){
        this.elevation = elevation;
    }

    public double getElevation(){
        return this.elevation;
    }

    public void setCentroidId(int centroidId){
        this.centroidId = centroidId;
    }

    public int getCentroidId(){
        return this.centroidId;
    }

    public List<Integer> getNeighbours() {
        return this.neighbours;
    }

    public void setNeighbours(List<Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getSegments() {
        return this.segments;
    }

    public void setSegments(List<Integer> segments) {
        this.segments = segments;
    }

}