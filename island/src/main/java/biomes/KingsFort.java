package biomes;

import meshcomponents.MyPolygon;

public class KingsFort extends WhittakerDiagram{

    public KingsFort(){
        this.diagram = createDiagram();
    }
    
    public String[][] createDiagram(){
        String [] [] d = {
            {"rf","x","x","x","x","x"},
            {"rf","rf","x","x","x","x"},
            {"sf","sf","x","x","x","x"},
            {"sf","sf","d","d","t","x"},
            {"sf","sf","sd","sd","t","t"} 
        };

        return d;
    }

    public String function(MyPolygon mp){
        int row = (int)((Math.ceil((mp.getHumidity()/0.2))));

        if(row > this.diagram.length){
            row = 0;
        }else{
            row = this.diagram.length - row;
        }

        int col = (int)((Math.ceil((mp.getHumidity()/100))));

        if(row > this.diagram[0].length){
            col = this.diagram[0].length - 1 ;
        }else{
            col = col - 1;
        }

        return this.diagram[row][col];
    }
}
