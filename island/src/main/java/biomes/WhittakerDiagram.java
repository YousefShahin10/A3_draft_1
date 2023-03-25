package biomes;

import colors.IslandColors;
import meshcomponents.MyMesh;
import meshcomponents.MyPolygon;

public abstract class WhittakerDiagram {

    //Note diagram is elevation by humidity
    protected String [] [] diagram;

    //Note scale
    protected int scaleY; //humidity
    protected int scaleX; //elevation


    public abstract String[][] createDiagram();

    public abstract String function(MyPolygon mp);

    public void generateBiomes(MyMesh mesh){
        for(MyPolygon mp : mesh.getPolygons()){
            if(mp.getColor().equals(IslandColors.LAND)){
                BiomeList bl = new BiomeList();

                String key = function(mp);

                mp.setColor(bl.getBiome(key));
            }
        }
    }
}//end class WhittakerDiagram